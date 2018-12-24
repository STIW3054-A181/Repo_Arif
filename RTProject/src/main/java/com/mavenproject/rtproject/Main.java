package com.mavenproject.rtproject;

import javax.swing.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

class TheThread extends Thread {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    private final String textInFile;
    private final int[] characterNumber;
    private final String fileNames;
    private final double X;

    public TheThread(String textInFile, int[] characterNumber, String fileNames, double X) {
        this.textInFile = textInFile;
        this.characterNumber = characterNumber;
        this.fileNames = fileNames;
        this.X = X;
    }

    @Override
    public void run() {

        double stDeviation = StandardDeviation.calculateSD(characterNumber);

        System.out.println("\nFile Name\t\t\t\t: " + ANSI_GREEN + fileNames + ANSI_RESET);
        System.out.println("Number Of Words\t\t\t: " + WordCounter.countWord(textInFile));
        System.out.println("Number Of Characters\t: " + CharCounter.countChar(textInFile));
        System.out.println("Standard Deviation\t\t: " + stDeviation);
        System.out.println("Z-Score\t\t\t\t\t: " + StandardDeviation.zScore(characterNumber, stDeviation, X));
        CharCounter.charAnalysis(textInFile);
    }

}

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) throws MalformedURLException, InterruptedException {


        URL url = new URL(Common.URL);//github repo download link

        File setFileName = new File("TargetFile.zip");//set the file downloaded file name
        String zipFile = "TargetFile.zip";//input file name in String, it should be same as setFileName

        AccessFiles m = new AccessFiles();//declare accessFile object
        m.downloadZip(url, setFileName);//downloading file from URL and the file name
        m.unzip(zipFile);//extract zip file, it cal also extract any other zip file

        ArrayList<String> fileNames = new ArrayList();
        fileNames = m.listFiles();

        ArrayList<String> textInFile = new ArrayList();//ArrayList to store texts from all files
        textInFile = m.readFiles(fileNames);//assign returned ArrayList from readFile() method to "list" ArrayList

        ArrayList<int[]> characterNumber = new ArrayList();

        TheThread[] TT = new TheThread[textInFile.size()];//thread array as file number as the size

        String input = JOptionPane.showInputDialog("Please Enter X value for Z-Score");
        double X = stringToInt(input);

        ArrayList<Double> SDList = new ArrayList();//for box plot
        ArrayList<Double> zScores = new ArrayList();

        for (int i = 0; i < fileNames.size(); i++) {
            //System.out.println(textInFile.get(i)); print all text inside every file
            characterNumber.add(StandardDeviation.countCharPerWord(textInFile.get(i)));


            TT[i] = new TheThread(textInFile.get(i), characterNumber.get(i), fileNames.get(i), X);//multithreading
            TT[i].start(); //the number of the thread started depend on how many the target files is

            Thread.sleep(1000);

            SDList.add(StandardDeviation.calculateSD(characterNumber.get(i)));
            zScores.add(StandardDeviation.zScore(characterNumber.get(i), SDList.get(i), X));
        }

        Normalization norm = new Normalization();
        norm.normalizeData(zScores, fileNames);
        Thread.sleep(1000);
        BoxPlot box_plot = new BoxPlot("Box Plot", SDList);
        box_plot.pack();
        box_plot.setSize(730, 500);
        box_plot.setVisible(true);
        //box_plot.setEnabled(false);
        box_plot.setLocationRelativeTo(null);

    }

    private static double stringToInt(String str) {
        try {
            if (str != null) {
                return Double.parseDouble(str);
            } else {
                System.out.println(ANSI_RED + "\nProgram discontinued" + ANSI_RESET);
                System.exit(0);
                return 0.0;
            }

        } catch (NumberFormatException nfe) {

            JOptionPane.showMessageDialog(null, "Please enter number only! \nX value will be set to zero");

            return 0.0;
        }
    }

}

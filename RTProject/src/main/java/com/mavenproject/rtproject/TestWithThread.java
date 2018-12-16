/*
This class is used to show example of how to use my methods
 */
package com.mavenproject.rtproject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Gifhary
 */
class TheThread extends Thread {

    private final String textInFile;
    private final int[] characterNumber;

    public TheThread(String textInFile, int[] characterNumber) {
        this.textInFile = textInFile;
        this.characterNumber = characterNumber;
    }

    @Override
    public void run() {
        System.out.println("Number Of Words\t\t: " + WordCounter.countWord(textInFile));
        System.out.println("Number Of Characters\t: " + CharCounter.countChar(textInFile));
        System.out.println("Standard Deviation\t: " + StandardDeviation.calculateSD(characterNumber));
        CharCounter.charAnalysis(textInFile);
    }
}


public class TestWithThread {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        URL url = new URL("https://github.com/gifhary/Test_File/archive/master.zip");//github repo download link

        File setFileName = new File("TargetFile.zip");//set the file downloaded file name
        String zipFile = "TargetFile.zip";//input file name in String, it should be same as setFileName

        AccessFiles m = new AccessFiles();//declare accessFile object
        m.downloadZip(url, setFileName);//downloading file from URL and the file name
        m.unzip(zipFile);//extract zip file, it cal also extract any other zip file

        ArrayList<String> textInFile = new ArrayList();//ArrayList to store texts from all files
        textInFile = m.readFiles(m.listFiles());//assign returned ArrayList from readFile() method to "list" ArrayList

        ArrayList<int[]> characterNumber = new ArrayList();
        
        TheThread[] TT = new TheThread[textInFile.size()];//thread array as file number as the size

        for (int i = 0; i < textInFile.size(); i++) {
            //System.out.println(textInFile.get(i)); print all text inside every file
            characterNumber.add(StandardDeviation.countCharPerWord(textInFile.get(i)));

            System.out.println("");
            System.out.println("File Name\t\t: " + m.listFiles().get(i));
            
            TT[i] = new TheThread(textInFile.get(i), characterNumber.get(i));//multithreading
            TT[i].start(); //the number of the thread started depend on how many the target files is
            
            Thread.sleep(1000);
        }

    }
}

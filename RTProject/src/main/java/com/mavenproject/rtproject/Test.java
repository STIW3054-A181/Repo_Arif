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
public class Test {

    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("https://github.com/gifhary/Test_File/archive/master.zip");//github repo download link

        File setFileName = new File("TargetFile.zip");//set the file downloaded file name
        String zipFile = "TargetFile.zip";//the file name in String

        AccessFiles m = new AccessFiles();//declare accessFile object
        m.downloadZip(url, setFileName);//downloading file from URL and the file name
        m.unzip(zipFile);//extract zip file, it cal also extract any other zip file

        ArrayList<String> list = new ArrayList();//ArrayList to store texts from all files
        list = m.readFiles(m.listFiles());//assign returned ArrayList from readFile() method to "list" ArrayList

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));//print all text inside every file
        }

    }
}

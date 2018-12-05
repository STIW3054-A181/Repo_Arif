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

        String sUrl = "https://github.com/gifhary/Test_File/archive/master.zip";
        URL url = new URL(sUrl);

        File setFileName = new File("TargetFile.zip");
        String zipFile = "TargetFile.zip";

        AccessFiles m = new AccessFiles();
        m.downloadZip(url, setFileName);
        m.unzip(zipFile);

        ArrayList<String> list = new ArrayList();
        list = m.readFiles(m.listFiles());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));//print all text inside every file
        }

    }
}

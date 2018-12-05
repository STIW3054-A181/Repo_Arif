/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public static String sUrl = "https://github.com/gifhary/Test_File/archive/master.zip";
    
    public static File file = new File("TargetFile.zip");
    
    public static String zipFile ="TargetFile.zip";    
    
    public static void main(String[] args) throws MalformedURLException {
        
        AccessFiles m = new AccessFiles();
        URL url = new URL(sUrl);
        m.downloadZip(url, file);
        
        String folderName = m.unzip(zipFile);
        
        m.listFiles(folderName);
        
        
    }
}

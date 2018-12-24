package com.mavenproject.rtproject;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public interface AccessFilesInterface {
    
    void downloadZip(URL url, File file);
    void unzip(String zipFile);
    ArrayList<String> listFiles();
    ArrayList<String> readFiles(ArrayList<String> listFiles);
    
}

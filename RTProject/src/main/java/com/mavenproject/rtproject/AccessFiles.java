/*
                                            READ ME PLEASE :) !!!

All method down bellow is to access the files in the github repository, download everything in the repository
as a ZIP file, this class also include method to extract the ZIP file and read the file, all the files that has
been read will be returned as string in a loop until all the text inside all the files has been returned.
 */
package com.mavenproject.rtproject;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author Gifhary
 */
public class AccessFiles {

    public String folderName = null;

    /*
    This method required URL source and file name for the downloaded file
    in this case, the URL should be github repo download link and the file name
    should be in .zip format
     */
    public void downloadZip(URL url, File file) {
        try {
            System.out.println("Accessing the URL . . .");
            InputStream input = url.openStream();
            if (file.exists()) {
                if (file.isDirectory()) {
                    throw new IOException("File '" + file + "' is a directory");
                }

                if (!file.canWrite()) {
                    throw new IOException("File '" + file + "' cannot be written");
                }
            } else {
                File parent = file.getParentFile();
                if ((parent != null) && (!parent.exists()) && (!parent.mkdirs())) {
                    throw new IOException("File '" + file + "' could not be created");
                }
            }

            FileOutputStream output = new FileOutputStream(file);

            byte[] buffer = new byte[4096];
            int n = 0;
            while (-1 != (n = input.read(buffer))) {
                output.write(buffer, 0, n);
            }

            input.close();
            output.close();

            System.out.println("File '" + file + "' downloaded successfully!");
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

    /*
    This method required zip file name as a String, this method will unzip/extract zip file to
    normal windows file and will return the folder name as a String. This method also require another
    method named extractFile(), the method is right under this method, so don't move or put any other
    method between this two method to avoid confusion. The first entry in the zip file must be a folder/directory.
    If not, the other method which depending on this won't work properly.
     */
    public void unzip(String zipFile) {
        try {
            ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFile));
            ZipEntry entry = zipIn.getNextEntry();

            folderName = entry.getName();//getting the folder name inside zip file

            while (entry != null) {
                String filePath = entry.getName();

                if (entry.isDirectory()) {//if the first entry in the zip file is a folder, it will create a folder
                    File dir = new File(filePath);
                    dir.mkdir();
                } else {
                    extractFile(zipIn, filePath); //<-- this method is under unzip method
                }

                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
            zipIn.close();
            System.out.println("File '" + zipFile + "' extracted successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Here it is :) let this method stay under unzip method
    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[4096];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }

    /*
    This method will listing all file names in a directory and returning all the names in String
    as an ArrayList. This method required folder/directory name as a String to work.
     */
    public ArrayList<String> listFiles() {
        ArrayList<String> fileNames = new ArrayList();

        File dir = new File(folderName);
        File[] files = dir.listFiles();

        for (File f : files) {
            fileNames.add(f.getName());
        }
        return fileNames;
    }

    /*
    This method require files name that is stored in ArrayList. This method is used for read PDF files
    which is previously downloaded, it will write the texts to ArrayList too as String, each file's texts
    will be stored in each node. If there are 5 files, there will be 5 nodes inside ArrayList.
     */
    public ArrayList<String> readFiles(ArrayList<String> listFiles) {
        ArrayList<String> textInFile = new ArrayList();
        try {
            for (int i = 0; i < listFiles.size(); i++) {//loop for each file in the directory

                PDDocument document = PDDocument.load(new File(folderName + listFiles.get(i)));
                PDFTextStripper stripper = new PDFTextStripper();
                String text = stripper.getText(document);

                textInFile.add(text);

                document.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return textInFile;
    }

}

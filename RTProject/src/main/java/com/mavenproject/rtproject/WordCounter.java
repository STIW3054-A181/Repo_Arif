package com.mavenproject.rtproject;


public class WordCounter {

    public static int countWord(String str) {
        int countWord = 0;

        if (!(str.equals(""))) {

            String[] wordList = str.split("\\s+");
            countWord += wordList.length;
        }
        return countWord;
    }

}

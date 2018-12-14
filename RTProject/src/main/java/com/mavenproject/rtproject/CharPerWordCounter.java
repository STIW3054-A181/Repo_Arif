/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavenproject.rtproject;

public class CharPerWord {

    public static int[] countCharPerWord(String str) {
        String[] separated = str.replaceAll("\\s+", " ").split(" ");
        int [] counter = new int [separated.length];
        
        for (int i = 0; i < separated.length; i++) {
            String s = separated[i];
            counter[i] = s.length();
        }
        
        return counter;
    }

}

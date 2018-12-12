package com.mavenproject.rtproject;

public class testStandardDev {

    public static void main(String[] args){

        StandardDeviation s = new StandardDeviation();
        double[] input = {9, 2, 5, 4, 12};
        
        System.out.println("Standard deviation is : "+s.calculateSD(input));

    }
}

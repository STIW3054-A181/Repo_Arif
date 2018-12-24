package com.mavenproject.rtproject;


public class testStandardDev {

    public static void main(String[] args){

        StandardDeviation s = new StandardDeviation();
        int [] input = {1, 2, 3, 7, 4};//different input size is allowed
        
        System.out.println("Standard deviation is : "+s.calculateSD(input));

    }
}

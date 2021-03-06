package com.mavenproject.rtproject;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/*
This class contain method to calculate standard deviation of a data that stored in array as double
it will print average, total number in the array and the standard deviation
the method will return the standard deviation value for other use if needed
 */
public class StandardDeviation {

    public static int[] countCharPerWord(String str) {
        String[] separated = str.replaceAll("\\s+", " ").split(" ");
        int[] counter = new int[separated.length];

        for (int i = 0; i < separated.length; i++) {
            String s = separated[i];
            counter[i] = s.length();
        }

        return counter;
    }

    public static double calculateSD(int[] values) {

        double sum = 0;
        double finalsum = 0;
        double average = 0;

        for (double i : values) {
            finalsum = (sum += i);
        }

        average = finalsum / (values.length);
        //System.out.println("Average : " + average);

        //System.out.println("Total numbers : " + values.length);
        double sumX = 0;
        double finalsumX = 0;
        ArrayList<Double> x1_average = new ArrayList();

        for (int i = 0; i < values.length; i++) {
            double fvalue = (Math.pow((values[i] - average), 2));
            x1_average.add(fvalue);
            //System.out.println("test : " + fvalue);
        }

        for (double i : x1_average) {
            finalsumX = (sumX += i);
        }

        double AverageX = finalsumX / (values.length);
        double stDeviation = Math.sqrt(AverageX);

        return stDeviation;
    }

    public static double zScore(int[] values, double standardDeviation, double X) {
        double zScore = 0;

        double sum = 0;
        double finalsum = 0;
        for (double i : values) {
            finalsum = (sum += i);
        }

        double average = finalsum / (values.length);

        double firstOperation = X - average;
        double lastOperation = firstOperation / standardDeviation;
        zScore = lastOperation;

        return zScore;
    }

}

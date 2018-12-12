package com.mavenproject.rtproject;

/*
This class contain method to calculate standard deviation of a data that stored in array as double
it will print average, total number in the array and the standard deviation
the method will return the standard deviation value for other use if needed
*/
public class StandardDeviation {

    public double calculate(double[] values) {

        double sum = 0;
        double finalsum = 0;
        double average = 0;

        for (double i : values) {
            finalsum = (sum += i);
        }

        average = finalsum / (values.length);
        System.out.println("Average : " + average);
        
        System.out.println("Total numbers : " + values.length);

        double sumX = 0;
        double finalsumX = 0;
        double[] x1_average = new double[2000];
        for (int i = 0; i < values.length; i++) {
            double fvalue = (Math.pow((values[i] - average), 2));
            x1_average[i] = fvalue;
        }

        for (double i : x1_average) {
            finalsumX = (sumX += i);
        }

        Double AverageX = finalsumX / (values.length);
        double stDeviation = Math.sqrt(AverageX);
        System.out.println("Standard Deviation : " + stDeviation);

        return stDeviation;
    }
}

import java.io.IOException;

public class StandardDeviationCalc {

    public static void main(String[] args) throws IOException {
        double [] values = {9, 2, 5, 4, 12, 7, 8, 11, 9, 3, 7, 4, 12, 5, 4, 10,
                9, 6, 9, 4 };   //change input values here
        double sum=0;
        double finalsum = 0;
        double average = 0;

        for( double i : values) {
            finalsum = (sum += i);
        }

        average = finalsum/(values.length);
        System.out.println("Average: "+ average);

        double sumX=0;
        double finalsumX=0;
        double[] x1_average = new double[2000];
        for (int i = 0; i<values.length; i++){
            double fvalue = (Math.pow((values[i] - average), 2));
            x1_average[i]= fvalue;
            System.out.println("test: "+ fvalue);
        }

        for(double i : x1_average) {
            finalsumX = (sumX += i);
        }

        Double AverageX = finalsumX/(values.length);
        System.out.println("E(X1-x1_average)^2/AverageX: "+ AverageX);
        double SquareRoot = Math.sqrt(AverageX);
        System.out.println("Standard Deviation: "+ SquareRoot);
    }
}
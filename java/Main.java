import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InvalidFormatException {

        long startTime = System.nanoTime();
        long start2 = System.nanoTime();

       /* System.out.println("Convert .xlsx to .txt \n");
        readwrite r = new readwrite();
        r.readData();*/

        System.out.println("Read test.txt file ....\n");
        System.out.println("Calculate and analyse data......\n");
        System.out.println("Open writer to Result.md file...\n");

        CountingWord cw = new CountingWord();
        cw.countWord();
    }
}

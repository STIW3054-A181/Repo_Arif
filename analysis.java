import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class analysis {

        private static final String FILENAME = "C:\\Users\\User\\desktop\\test.txt";

        public void read() throws FileNotFoundException {
            Scanner sc = new Scanner(new FileInputStream(new File(FILENAME)));
            int count = 0;
            while (sc.hasNext()) {
                String[] s = sc.next().split("d*[.@:=#-]");

                for (int i = 0; i < s.length; i++) {
                    if (!s[i].isEmpty()) {
                        count++;
                    }
                }
            }
            System.out.println("Number of words meth read() : " + count + "\n");
        }

        public void countWord() throws IOException {

            try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
                int count = 0;
                int charCount = 0;
                int charCount2 = 0;
                int ttlline = 0;
                int max = 0;
                int min = 0;
                int lines = 0;
                int sum = 0;
                double avg = 0;
                String line = br.readLine();
                while (line != null) {
                    ttlline++;
                    charCount = charCount + line.length();

                    String[] myWords = line.replaceAll("\\s", " ").split(" ");

                    for (String s : myWords) {
                        charCount2 = charCount2 + s.length();

                    }
                    count = count + myWords.length;

                    line = br.readLine();
                }

                System.out.printf("Number of words \t\t\t | %6d \n", count);
                System.out.println("|:--|--:|");
                System.out.printf("Number of lines \t\t\t | %6d \n", ttlline);
                System.out.printf("Number of characters without space \t| %6d \n", charCount2);
                System.out.printf("Number of characters with space \t| %6d \n", charCount);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void analyseLine() {

            try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
                int count = 0;
                int charCount = 0;
                int charCount2 = 0;
                int ttlline = 0;
                int max = 0;
                int min = 0;
                int lines = 0;
                double sum = 0;
                double avg = 0;
                String line = br.readLine();
                System.out.println("| Line | Number of Words |");
                System.out.println("|:--:|:--:|");

                while (line != null) {
                    ttlline++;
                    charCount = charCount + line.length();

                    String[] myWords = line.replaceAll("\\s", " ").split(" ");

                    int m = myWords.length;
                    System.out.printf("| %2d| %2d |\n", ttlline, m);
                    if (m > max) {
                        lines = ttlline;
                        max = m;
                    }
                    if (m < min) {
                        lines = ttlline;
                        min = m;
                    }
                    sum += m;
                    avg = sum / ttlline;

                    for (String s : myWords) {
                        charCount2 = charCount2 + s.length();

                    }
                    count = count + myWords.length;

                    line = br.readLine();
                }

                System.out.println("<b> Highest number of words | <b> " + max);

                System.out.println("<b> Lowest number of words | <b> " + min);
                System.out.printf("<b> Average number of words for each line | <b> %.2f \n ", avg);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void readDetails() {
            try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
                int letter = 0;
                int space = 0;
                int num = 0;
                int other = 0;
                String line = br.readLine();
                while (line != null) {
                    String x = line;
                    char[] ch = x.toCharArray();

                    for (int i = 0; i < x.length(); i++) {
                        if (Character.isLetter(ch[i])) {
                            letter++;
                        } else if (Character.isDigit(ch[i])) {
                            num++;
                        } else if (Character.isSpaceChar(ch[i])) {
                            space++;
                        } else {
                            other++;
                        }
                    }

                    line = br.readLine();
                }
                System.out.printf("Number of characters - letter \t\t | %6d \n", letter);
                System.out.printf("Number of characters - space \t\t | %6d \n", space);
                System.out.printf("Number of characters - number \t\t | %6d \n", num);
                System.out.printf("Number of characters - other\t\t | %6d \n", other);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void readChar() {
            try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

                String line = br.readLine();
                int value;
                HashMap<Character, Integer> map = new HashMap<Character, Integer>();
                System.out.println("|Character|Count|");
                System.out.println("|:--:|:--:|");
                while (line != null) {
                    for (int i = 0; i < line.length(); i++) {
                        if (map.containsKey(line.charAt(i))) {
                            value = map.get(line.charAt(i));
                            value++;
                            map.put(line.charAt(i), value);
                        } else {
                            map.put(line.charAt(i), 1);
                        }
                    }
                    line = br.readLine();
                }
                for (Character key : map.keySet()) {
                    System.out.printf("| '%c' |   %5d |\n", key, map.get(key));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

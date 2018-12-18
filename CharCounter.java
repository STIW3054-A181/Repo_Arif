
package com.mavenproject.rtproject;

import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharCounter {
    
    public static int countChar(String str) {
        int charCount = 0;

        if (!(str.equals(""))) {
            String myWords = str.replaceAll("\\s+", "");
            charCount = myWords.length();
        }
        return charCount;
    }

    public static Map charAnalysis(String str) {

        StringReader reader = new StringReader(str);

        int nextLetter;
        int total = 0;
        int other = 0;
        Map ans = null;
        int[] count = new int[26];

        try {
            System.out.println("Letter            Frequency");
            while ((nextLetter = reader.read()) != -1) {
                char current = (char) nextLetter;
                current = Character.toLowerCase(current);
                if (current >= 'a' && current <= 'z') {
                    count[current - 'a']++;
                    total++;
                } else {
                    other++;
                }
            }
            ans = sorting(count);
            printMap(ans);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }

    private static Map sorting(int[] count) {
        Map m = new LinkedHashMap<String, Integer>() {
        };
        int k = 0;
        for (int i = 0; i < 26; i++) {
            int max = -1;
            for (int j = 0; j < 26; j++) {
                if (max < count[j]) {
                    max = count[j];
                    k = j;
                }
            }
            count[k] = -1;
            if (max != 0) {
                m.put(((char) (k + 97)) + "", max);
            }
            max = 0;
        }
        return m;
    }

    private static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("  " + entry.getKey() + "        :        " + entry.getValue());
        }
    }
    
}

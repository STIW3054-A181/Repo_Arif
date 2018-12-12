import org.graalvm.compiler.word.Word;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Util {

        public static boolean isRightFile(File file) {
            return isExtensionMatch(file, "pdf") || isExtensionMatch(file, "txt");
        }

        public static String getText(File file) throws IOException {
            if (isExtensionMatch(file, "pdf")) {
                return getTextFromPDF(file);
            } else if (isExtensionMatch(file, "txt")) {
                return getTextFromTextFile(file);
            }

            return "";
        }

        public static ArrayList<Word> getWordFrequencies(String documentString, String regex) {
            String[] splittedWordBySpace = documentString.split(regex);

            TreeMap<String, Word> map = new TreeMap<>();
            for (int i = 0; i < splittedWordBySpace.length; i++) {
                if (splittedWordBySpace[i].length() <= 0) {
                    continue;
                }
                String singleWord = splittedWordBySpace[i].trim();
                Word word = map.get(singleWord);
                if (word == null) {
                    map.put(singleWord, new Word(singleWord));
                } else {
                    word.count++;
                }
            }
            ArrayList<Word> unsortedWords = new ArrayList<>(map.values());
            Collections.sort(unsortedWords);
            return unsortedWords;
        }

        public static boolean isExtensionMatch(File file, String extension) {
            String name = file.getName();
            String fileExtension = name.substring(name.lastIndexOf('.') + 1);
            if (fileExtension != null && fileExtension.equals(extension)) {
                return true;
            }
            return false;
        }

        private static String getTextFromPDF(File file) throws IOException {
            PDDocument document = PDDocument.load(file);
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            document.close();
            return text;
        }

        private static String getTextFromTextFile(File file) {
//        FileReader reader = new FileReader(file);
            return "";
        }
}

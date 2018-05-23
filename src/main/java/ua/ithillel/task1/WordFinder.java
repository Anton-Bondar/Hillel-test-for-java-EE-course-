package ua.ithillel.task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: anbo
 * Date: 22.05.2018
 */
public class WordFinder {

    private final List<Character> UNAVAILABLE_SYMBOLS = new ArrayList<>(Arrays.asList('.', '/', '-', ';', ':', ',','\"'));

    public void find(String pathToFile) {
        File file = new File(pathToFile);
        String textFromFile = parseFile(file);
        String[] words = textFromFile.split(" ");
        System.out.println("The file "+file.getName() +" contains "+words.length+" words");
        for (int iterator = 0; iterator < words.length; iterator++) {
            System.out.println(iterator+1+")"+words[iterator]);
        }
    }

    protected String parseFile(File file) {
        StringBuilder result = new StringBuilder();
        if (validateInputData(file)) {
            try {
                FileInputStream fis = new FileInputStream(file);
                char current;
                while (fis.available() > 0) {
                    current = (char) fis.read();
                    if (!UNAVAILABLE_SYMBOLS.contains(current)) {
                        result.append(current);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }

    private boolean validateInputData(File file) {
        if (!file.exists()) {
            System.out.println(file.getPath() + " does not exist.");
            return false;
        }
        if (!(file.isFile() && file.canRead())) {
            System.out.println(file.getName() + " cannot be read");
            return false;
        }
        return true;
    }
}

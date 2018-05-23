package ua.ithillel.task1;

import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;
import sun.misc.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Author: anbo
 * Date: 22.05.2018
 */
public class WordFinder {

    private final List<Character> UNAVAILABLE_SYMBOLS = new ArrayList<>(Arrays.asList('.','/','-',';',':',','));

    public boolean find(String pathToFile, String targetWord) {
        String filteredWord = filterInputText(targetWord);
        String textFromFile = parseFile(pathToFile);


    }

    protected String filterInputText(String text) {
        StringBuilder result = new StringBuilder();
        char[] symbols = text.toCharArray();
        for (char symbol : symbols) {
            if (!UNAVAILABLE_SYMBOLS.contains(symbol)) {
                result.append(symbol);
            }
        }
        return result.toString();
    }

    protected String parseFile (String absolutePath) {
        StringBuilder result = new StringBuilder();
        File file = new File(absolutePath);
        if (validateInputData(file)) {
            Scanner sc = null;
            try {
                sc = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while (sc.hasNextLine()) {
                result.append(sc.nextLine());
            }
            sc.close();
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

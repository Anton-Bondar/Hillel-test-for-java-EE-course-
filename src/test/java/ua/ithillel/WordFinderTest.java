package ua.ithillel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.ithillel.task1.WordFinder;
import ua.ithillel.task2.ArrayToCollectionConverter;

/**
 * Author: anbo
 * Date: 22.05.2018
 */
public class WordFinderTest extends WordFinder {

    private String PATH_TO_FILE = "/Users/antonbondar/Desktop/Java/Java_Projects/Hillel-test-for-java-EE-course/src/main/resources/file_without_unavailable_symbols.txt";

    @Test
    public void parseFileWhenCorrectPathThanReturnSourceTextFromFile() {
        String result = parseFile(PATH_TO_FILE);

        String expectedResult = "This is my first file.";
        Assert.assertEquals(expectedResult,result);
    }

    @Test
    public void filterInputTextWhenTextContainsAvailableSymbolsThanReturnSourceText() {
        String sourceText = new String("This is my first response. There is: 1,2,3; There is -life/. Thanks!");
        String result = filterInputText(sourceText);

        String expectedResult = "This is my first response There is 123 There is life Thanks!";
        Assert.assertEquals(expectedResult,result);
    }

}

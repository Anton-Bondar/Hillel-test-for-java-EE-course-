package ua.ithillel;

import org.junit.Assert;
import org.junit.Test;
import ua.ithillel.task1.WordFinder;

import java.io.File;

/**
 * Author: anbo
 * Date: 22.05.2018
 */
public class WordFinderTest extends WordFinder {

    private String PATH_TO_FILE_WITHOUT_UNAVAILABLE_SYMBOLS = "E:\\projects\\Hillel-test-for-java-EE-course-\\src\\main\\resources\\file_without_unavailable_symbols.txt";
    private String PATH_TO_FILE_WITH_UNAVAILABLE_SYMBOLS = "E:\\projects\\Hillel-test-for-java-EE-course-\\src\\main\\resources\\file_with_unavailable_symbols.txt";

    @Test
    public void parseFileWhenSourceTextIsCorrectThanReturnSourceTextFromFile() {
        File file = new File(PATH_TO_FILE_WITHOUT_UNAVAILABLE_SYMBOLS);
        String result = parseFile(file);
        String expectedResult = "This is my first file !";

        Assert.assertEquals(expectedResult,result);
    }

    @Test
    public void parseFileWhenSourceTextIsInCorrectThanReturnFilteredTextFromFile() {
        String expectedResult = "This is my first response There is 123 There is life Thanks! ANBO";
        File file = new File(PATH_TO_FILE_WITH_UNAVAILABLE_SYMBOLS);
        String result = parseFile(file);

        Assert.assertEquals(expectedResult,result);
    }

    @Test
    public void testFind() {
        find(PATH_TO_FILE_WITHOUT_UNAVAILABLE_SYMBOLS);
        find(PATH_TO_FILE_WITH_UNAVAILABLE_SYMBOLS);
    }
}

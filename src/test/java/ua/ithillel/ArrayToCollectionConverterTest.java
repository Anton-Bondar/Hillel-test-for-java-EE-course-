package ua.ithillel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.ithillel.task1.ArrayToCollectionConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Author: anbo
 * Date: 21.05.2018
 */
public class ArrayToCollectionConverterTest {

    private ArrayToCollectionConverter converter;

    @Before
    public void setUp() {
        converter = new ArrayToCollectionConverter();
    }

    @Test
    public void convert_when_intArray_than_collectionOfIntegers() {
        Object[] data = {1,2,3};
        Collection<Object> result = converter.convert(data, new ArrayList<>());
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(1,2,3));

        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void convert_when_stringArray_than_collectionOfStrings () {
        Object[] data = {"a","b","c"};
        Collection<Object> result = converter.convert(data, new ArrayList<>());
        List<String> expectedResult = new ArrayList<>(Arrays.asList("a","b","c"));

        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void convert_when_null_than_emptyCollection() {
        Collection<Object> result = converter.convert(null, new ArrayList<>());
        List<Object> expectedResult = new ArrayList<>();

        Assert.assertEquals(expectedResult, result);
    }
}

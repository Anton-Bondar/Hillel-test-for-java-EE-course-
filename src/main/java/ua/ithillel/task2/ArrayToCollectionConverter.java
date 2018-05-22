package ua.ithillel.task2;

import java.util.Collection;

/**
 * Author: anbo
 * Date: 21.05.2018
 */
public class ArrayToCollectionConverter {

    public <T> Collection<T> convert(Object[] array, Collection<T> collection) {
        if (array != null && collection != null) {
            for (Object arrayElement : array) {
                collection.add((T) arrayElement);
            }
        }
        return collection;
    }
}


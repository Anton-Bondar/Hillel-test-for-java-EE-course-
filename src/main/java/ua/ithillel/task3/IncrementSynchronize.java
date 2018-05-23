package ua.ithillel.task3;

/**
 * Author: anbo
 * Date: 23.05.2018
 */
public class IncrementSynchronize {
    private int value = 0;

    private Object lock = new Object();

    public synchronized int getNextValue1() {
        value++;
        return value;
    }

    int getNextValue2() {
        synchronized (this) {
            value++;
        }
        return value;
    }

    int getNextValue3() {
        synchronized (lock) {
            value++;
            return value;
        }
    }
}


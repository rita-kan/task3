package com.company;

import java.util.Random;

public class Utils {

    public static Integer[] randomArray(int size) {
        Random random = new Random();

        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt() % (2 * size);
        }

        return array;
    }

}
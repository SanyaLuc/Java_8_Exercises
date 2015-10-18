package edu.san.luc.java8;

import java.util.Arrays;

/**
 * Created by sanya on 29.09.15.
 */
public class ArraySort {

    public static void main(String[] args) {
        String[] words = {"cat","Dog","hippo","Antelope","lion"};

        Arrays.sort(words, String::compareToIgnoreCase);

        System.out.println(Arrays.asList(words));

        Arrays.sort(words, String::compareTo);

        System.out.println(Arrays.asList(words));
    }
}

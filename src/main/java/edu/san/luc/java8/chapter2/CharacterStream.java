package edu.san.luc.java8.chapter2;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

/**
 * Created by sanya on 09.10.15.
 */
public class CharacterStream {
    public static void main(String[] args) {
        String word = "boat";
        Stream<Character> charStream = rangeClosed(0, word.length() - 1)
                .mapToObj(i -> word.charAt(i));

        System.out.println(charStream.collect(toList()));
    }
}

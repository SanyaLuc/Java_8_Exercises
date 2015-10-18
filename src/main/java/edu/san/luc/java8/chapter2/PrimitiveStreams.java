package edu.san.luc.java8.chapter2;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by sanya on 09.10.15.
 */
public class PrimitiveStreams {
    public static void main(String[] args) {
        int[] values = { 1, 4, 9, 16 };
        Integer[] valueObjs = { 1, 4, 9, 16 };
        Stream<Integer> stream1 = Stream.of(valueObjs);
        Stream<int[]> stream2 = Stream.of(values);
        IntStream stream3 = Arrays.stream(values);
        IntStream stream4 = IntStream.of(values);
    }
}

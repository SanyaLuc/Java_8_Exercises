package edu.san.luc.java8.chapter2;

import java.util.stream.Stream;

/**
 * Created by sanya on 09.10.15.
 */
public class FintiteStream {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2);
        System.out.println(isFinite(stream));

        Stream<Long> ranNums = Stream.iterate(0L, x -> (20L * x + 10L) % 30L);
        System.out.println(isFinite(ranNums));

    }

    public static <T> boolean isFinite(Stream<T> stream){
        return stream.spliterator().estimateSize() < Long.MAX_VALUE;
    }
}

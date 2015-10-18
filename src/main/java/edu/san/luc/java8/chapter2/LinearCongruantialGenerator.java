package edu.san.luc.java8.chapter2;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.pow;
import static java.util.stream.Collectors.toList;

/**
 * Created by sanya on 09.10.15.
 */
public class LinearCongruantialGenerator {
    public static void main(String[] args) {
        long seed = 0;
        long a = 25214903917L;
        long c = 11;
        long m = (long) pow(2, 48);

        long xi = seed;
        for (int i = 0; i < 10; i++) {
            xi = (a * xi + c) % m;
            System.out.println(xi);
        }

        Stream<Long> ranNums = Stream.iterate(seed, x -> (a * x + c) % m);
        System.out.println(ranNums.limit(10).collect(toList()));
    }
}

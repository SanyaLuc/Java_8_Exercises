package edu.san.luc.java8.chapter2;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by sanya on 12.10.15.
 */
public class AverageNumber {
    public static void main(String[] args) {
        IntStream stream = IntStream.of(1, 2, 5, 10);
        OptionalDouble result = stream.average();
        result.ifPresent(a -> System.out.println(a));

        Stream<Integer> stream1 = Stream.of(1, 2, 5, 10);
        long[] result1 = stream1.reduce(new long[2],
                (r,i) -> {r[0]+=i; r[1]++; return r;},
                (l,r) -> {l[0]+=r[0]; l[1]+=r[1]; return l;});

        System.out.println((double)result1[0]/result1[1]);
    }
}

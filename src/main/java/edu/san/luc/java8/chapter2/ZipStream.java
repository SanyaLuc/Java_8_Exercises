package edu.san.luc.java8.chapter2;

import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Stream.of;

/**
 * Created by sanya on 10.10.15.
 */
public class ZipStream {
    public static void main(String[] args) {
        Stream<Integer> stream1 = of(1, 3, 5, 7);
        Stream<Integer> stream2 = of(2, 4, 6);

        Iterator<Integer> i2 = stream2.iterator();
        Stream<Integer> stream = stream1.filter(e -> i2.hasNext())
                .flatMap(e -> of(e, i2.next()));

        System.out.println(stream.collect(Collectors.toList()));
    }

}

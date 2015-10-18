package edu.san.luc.java8.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * Created by sanya on 11.10.15.
 */
public class ListJoiner {
    public static void main(String[] args) {
        ArrayList<String> family1 = new ArrayList<>(asList("mom", "dad"));
        ArrayList<String> family2 = new ArrayList<>(asList("grandmomy", "granddaddy"));
        ArrayList<String> family3 = new ArrayList<>(asList("son", "daughter"));
        Stream<ArrayList<String>> s = Stream.of(family1, family2);

        Optional<ArrayList<String>> r1 = s.reduce(
                (f1, f2) -> new ArrayList<String>(){{addAll(f1);addAll(f2);}});
        r1.ifPresent(l -> System.out.println(l));

        s = Stream.of(family1, family2);

        ArrayList<String> r2 = s.reduce(new ArrayList<String>(),
                (f1, f2) -> {f1.addAll(f2); return f1;});
        System.out.println(r2);

        s = Stream.of(family1, family2);

        ArrayList<String> r3 = s.reduce(new ArrayList<String>(),
                (f1, f2) -> {f1.addAll(f2); return f1;},
                (f1, f2) -> {f1.addAll(f2); return f1;});
        System.out.println(r3);
    }
}

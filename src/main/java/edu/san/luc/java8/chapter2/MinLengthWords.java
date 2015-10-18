package edu.san.luc.java8.chapter2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.counting;

/**
 * Created by sanya on 17.10.15.
 */
public class MinLengthWords {
    public static void main(String[] args) throws URISyntaxException, IOException {
        byte[] bytes = { (byte) 0b10100, (byte) 0b10101};
        BitSet bitSet = BitSet.valueOf(bytes);
        System.out.println(bitSet);

        String contents = new String(Files.readAllBytes(
                Paths.get(ClassLoader.getSystemResource("S 1 E 1.vac").toURI())), StandardCharsets.UTF_8); // Read file into string
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        AtomicInteger[] counts = new AtomicInteger[12];

        words.parallelStream().forEach(w -> {
            if (w.length() < 8) {
                AtomicInteger count = counts[w.length()];
                if (count == null) {
                    count = new AtomicInteger(0);
                    counts[w.length()] = count;
                }
                count.incrementAndGet();
            }
        });

        System.out.println(Arrays.asList(counts));

        Map<Integer, Long> countMap = words.parallelStream().filter(w -> w.length() < 8).collect(groupingBy(String::length, counting()));
        TreeMap<Integer,Long> sortedCountMap = new TreeMap<Integer,Long>(Integer::compareTo);
        sortedCountMap.putAll(countMap);
        System.out.println(sortedCountMap.values());
    }
}

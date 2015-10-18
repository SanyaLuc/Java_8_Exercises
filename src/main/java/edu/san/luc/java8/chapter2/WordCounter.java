package edu.san.luc.java8.chapter2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sanya on 08.10.15.
 */
public class WordCounter {

    public static void main(String[] args) throws IOException, URISyntaxException {
        String contents = new String(Files.readAllBytes(
                Paths.get(ClassLoader.getSystemResource("S 1 E 1.vac").toURI())), StandardCharsets.UTF_8); // Read file into string
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        System.out.println(words);
        Collections.sort(words);

        long count = words.stream().filter(w -> w.length() > 8)
                .peek(w -> System.out.println(w)).count();
        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length() > 8)
                .peek(w -> System.out.println(w)).count();
        System.out.println(count);

        Stream<String> stream = words.stream().filter(w ->
        {
            if(w.length() == 5){
                System.out.println("#" + w);
                return true;
            }
            return false;
        });
        System.out.println("No filtered yet");
        List<String> result = stream.collect(Collectors.toList());
        System.out.println(result);
    }
}

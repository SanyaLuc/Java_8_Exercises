package edu.san.luc.java8.chapter1;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by sanya on 29.09.15.
 */
public class FileFiltering {
    public static void main(String[] args) throws URISyntaxException {
        URL url = FileFiltering.class.getClassLoader().getResource("hosts.list");
        File resourceDir = new File(url.toURI()).getParentFile();
        File[] allFiles = resourceDir.listFiles();

        Arrays.sort(allFiles, (f1, f2) ->
                        f1.isDirectory() != f2.isDirectory()
                                ? (f1.isDirectory() ? -1 : 1)
                                : (f1.getName().compareTo(f2.getName()))
        );

        System.out.println("All files: "+Arrays.asList(allFiles));

        File[] onlyDirs = resourceDir.listFiles(file -> file.isDirectory());

        System.out.println("Only directories: "+Arrays.asList(onlyDirs));

        String extension = "list";

        String[] onlyWithExts = resourceDir.list((dir, filename) -> filename.endsWith(extension));

        System.out.format("Only files with %s extension:%s \n", extension, Arrays.asList(onlyWithExts).toString());
    }
}

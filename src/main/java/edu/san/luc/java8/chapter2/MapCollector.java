package edu.san.luc.java8.chapter2;

import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sanya on 05.10.15.
 */
public class MapCollector {
    public static void main(String[] args) {

        Locale[] localeArray = Locale.getAvailableLocales();
        for (int i = 0; i < localeArray.length; i++) {
            Locale locale = localeArray[i];
            System.out.println(locale.getDisplayCountry()+" "+locale.getDisplayLanguage()+" "+locale.getDisplayLanguage(locale));
        }
        System.out.println("##################################################################");
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = locales.collect(
                Collectors.toMap(
                        l -> l.getDisplayLanguage(),
                        l -> l.getDisplayLanguage(l),
                        (existingValue, newValue) -> existingValue));
//                Collectors.toMap(
//                        l -> l.getDisplayLanguage(),
//                        l -> l.getDisplayLanguage(l)));
        for (String local : languageNames.keySet()) {
            System.out.println(local+" "+languageNames.get(local));
        }
    }
}

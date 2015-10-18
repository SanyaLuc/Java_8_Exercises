package edu.san.luc.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by sanya on 01.10.15.
 */
public class LoopByCollection {
    public static void main(String[] args) {
        String[] names = { "Peter", "Paul", "Mary" };
        List<Runnable> runners = new ArrayList<>();
        for (String name : names)
            runners.add(() -> System.out.println(name));

        for (Runnable runner : runners) {
            Thread thread = new Thread(runner);
            thread.run();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        runners.clear();

        for (int i = 0; i < names.length; i++) {
            String name = names[i];

            runners.add(() -> System.out.println(name));
        }

        for (Runnable runner : runners) {
            Thread thread = new Thread(runner);
            thread.run();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        CollectionHandler<String> handler = new ArrayListHandler<String>();
        for (String name : names) {
            handler.add(name);
        }


        handler.forEachIf(item -> System.out.println(item), item -> item.startsWith("P"));
    }


    static class ArrayListHandler<E> extends ArrayList<E> implements CollectionHandler<E>{}

    static interface CollectionHandler<E> extends Collection<E> {
        default void forEachIf(Consumer<E> action, Predicate<E> filter){
            for(E item:this){
                if(filter.test(item))
                    action.accept(item);
            }
        }
    }
}

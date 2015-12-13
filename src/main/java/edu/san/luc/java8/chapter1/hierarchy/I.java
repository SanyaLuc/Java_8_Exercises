package edu.san.luc.java8.chapter1.hierarchy;

/**
 * Created by sanya on 02.10.15.
 */
public interface I {
    void f1();
    default void f2(){

    }
    static void f3(){

    }
}

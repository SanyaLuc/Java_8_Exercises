package edu.san.luc.java8.chapter1.hierarchy;

/**
 * Created by sanya on 02.10.15.
 */
public class C1 implements I,J {
    @Override
    public void f1() {

    }

    @Override
    public void f2() {
        I.super.f2();
    }
}


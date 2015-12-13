package edu.san.luc.java8.chapter1;

import java.util.concurrent.Callable;

/**
 * Created by sanya on 01.10.15.
 */
public class ThreadRunning {
    public static void main(String[] args) {
        new Thread(uncheck(
                () -> { System.out.println("Zzz"); Thread.sleep(1000);})).start();

        new Thread(uncheck1(
                () -> { System.out.println("Zzz1"); Thread.sleep(1000); return null;})).start();

        new Thread(andThen(() -> System.out.println("first"), () -> System.out.println("second"))).start();
    }

    public static Runnable andThen(Runnable first, Runnable second){
        return () -> {
            first.run();

            second.run();
        };
    }

    public static Runnable uncheck(RunnableEx runnableEx){
        return () -> {
            try{
                runnableEx.run();
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        };
    }

    public static Runnable uncheck1(Callable<Void> runnableEx){
        return () -> {
            try{
                runnableEx.call();
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        };
    }

    interface RunnableEx {
        void run() throws Exception;
    }
}

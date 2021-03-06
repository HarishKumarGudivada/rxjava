package com.reactive.parallel;

import java.util.Date;
import java.util.Random;

import rx.Observable;
import rx.schedulers.Schedulers;

public class ParallelProgramming {
	
    private static final Random rand = new Random();

 public static void main(String[] args) {

        Observable<Integer> vals = Observable.range(1,10);

        vals.flatMap(val -> Observable.just(val)
                    .subscribeOn(Schedulers.newThread())
                    .map(i -> intenseCalculation(i))
        ).subscribe(val -> System.out.println("Subscriber received "
                + val + " on "
                + Thread.currentThread().getName() + " at " + new Date()));

        waitSleep();
        
        System.out.println("end" + " at " + new Date());
	 
	 /*Observable<Integer> vals = Observable.range(1,10);
	 vals.map(i -> intenseCalculation(i))
	 .subscribe(val -> System.out.println(val));*/
    }
    public static void waitSleep() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static int intenseCalculation(int i) {
        try {
            System.out.println("Calculating " + i + " on " + Thread.currentThread().getName() + " at " + new Date());
            Thread.sleep(5000);
            return i;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
}

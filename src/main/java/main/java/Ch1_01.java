package main.java;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Ch1_01 {

    public static void main(String [] args) throws InterruptedException {
        Observable<String> myStrings =
                Observable.just("alpha","Beta","Gamma");
        myStrings.subscribe(System.out::println);

        myStrings.map(s->s.length()).subscribe(
                s->System.out.println(s));

        fireInSeconds();
    }

    private static void fireInSeconds() throws InterruptedException {
        Observable<Long> secondIntervals = Observable.interval(1, TimeUnit.SECONDS);

        secondIntervals.subscribe(s->System.out.println(s));
        Thread.sleep(5000);
    }
}

package main.java;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ConditionalOperators {

    public static void main(String [] args){

         Observable.range(10,30)
                .takeWhile(i->i<20).subscribe(
                        s->System.out.println(s)
                );
    }
}

 class takeIf {

    public static void main(String [] args){

        Observable.range(10,30)
                .takeLast(5).subscribe(
                        s->System.out.println(s)
                );
    }
}

class takeUntil {

    public static void main(String [] args) throws InterruptedException {

        @NonNull Observable<Integer> source = Observable.range(1, 5);

//        Thread.sleep(5000);
        Observable.range(10,30)
                .takeUntil(source).subscribe(
                        s->System.out.println(s)
                );
    }
}

class resortIfEmpty {

    public static void main(String [] args) throws InterruptedException {

        @NonNull Observable<Integer> source = Observable.range(1, 5);

//        Thread.sleep(5000);
        source.filter(i->i>10).defaultIfEmpty(
                2
        ).subscribe(System.out::println);
    }
}

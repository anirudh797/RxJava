package main.java;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class SpecialObservables {

    public static  void main(String [] args){
        //emits only single item
        Single.just("Hello").map(String::length).subscribe(
               s-> System.out.println(s),
                e->System.out.println(e)
        );
    }
}

 class MaybeObservable {

    //emits 1 or 0 items
    public static  void main(String [] args){
        Maybe.just("Hello").map(String::length).subscribe(
                s-> System.out.println(s),
                e->System.out.println(e)
        );

        Maybe.empty().subscribe(
                s->System.out.println("item"),
                e->System.out.println(e),
                ()->System.out.println("Done")
        );
    }
}

class Dispose {

    //emits 1 or 0 items
    public static  void main(String [] args) throws InterruptedException {
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);

        Disposable disposable = seconds.subscribe(
                l->System.out.println("Received : "+l)
        ) ;

        Thread.sleep(5000);
        disposable.dispose();
        Thread.sleep(5000);
    }
}

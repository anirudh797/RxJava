package main.java;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.ResourceObserver;

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

class ResourceObservable {

    //to explicitely handle the disposable
    public static  void main(String [] args) throws InterruptedException {
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);

        ResourceObserver<Long> myObserver = new ResourceObserver<Long>(){

            @Override
            public void onNext(@NonNull Long aLong) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }

        };
        //capture disposable
        Disposable disposable = seconds.subscribeWith(myObserver);
    }
}

class CompositeDisposables {

    //to explicitely handle the disposable
    public static  void main(String [] args) throws InterruptedException {
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);

        Disposable disposable1 = seconds.subscribe(
                l->System.out.println("Observer 1 "+ l)
        );
        Disposable disposable2 = seconds.subscribe(
                l->System.out.println("Observer 2 "+ l)
        );

        CompositeDisposable d = new CompositeDisposable();
        d.addAll(disposable1,disposable2);
        Thread.sleep(5000);

        d.dispose();
        Thread.sleep(5000);
        //capture disposable

    }
}
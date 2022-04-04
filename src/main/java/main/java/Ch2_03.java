package main.java;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.List;

public class Ch2_03 {

    public static void main(String[] args) {
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("Alpha");
            emitter.onNext("Beta");
            emitter.onNext("Gamma");
            emitter.onComplete();

        });

        Observable<Integer> lengths = source.map(String::length);
        Observable<Integer> filtered = lengths.filter(i-> i>4);
        filtered.subscribe(s->System.out.println(s));

    }
}

class Ch2_04 {

    //chaining operators
    public static void main(String[] args) {
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("Alpha");
            emitter.onNext("Beta");
            emitter.onNext("Gamma");
            emitter.onComplete();

        });
        source.map(String::length).filter(i-> i>4).subscribe(s->System.out.println(s));

    }
}

class Ch2_06 {

    //using from Iterable
    public static void main(String[] args) {

        List<String> items = List.of("alpha","beta","gamma");
        Observable<String> source = Observable.fromIterable(items);
        source.map(String::length).filter(i-> i>4).subscribe(s->System.out.println(s));

    }
}

class Ch2_07 {

    //using from Iterable
    public static void main(String[] args) {

        Observable<String> source = Observable.just("alpha", "beta", "gamma");

        Observer<Integer> myObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull
                                       Integer s) {
                System.out.println("Received Value : " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        source.map(String::length).filter(i -> i > 4).subscribe(myObserver);

    }
    }

    class Ch2_08 {

        //cold Observable
        public static void main(String[] args) {

            Observable<String> source =
                    Observable.just("Alpha","Beta","Gamma");

            source.subscribe(s->System.out.println("Observer 1: "+s));

            source.map(String::length).filter(i-> i >=5 ).subscribe(s->System.out.println("Observer 2: "+s));

        }

    }

class Ch2_14 {

    //converting cold to hot observable
    public static void main(String[] args) {

        ConnectableObservable<String> source =
                Observable.just("Alpha","Beta","Gamma").publish();

        source.subscribe(s->System.out.println("Observer 1: "+s));

        source.map(String::length).subscribe(s->System.out.println("Observer 2: "+s));
        source.connect();


    }

}






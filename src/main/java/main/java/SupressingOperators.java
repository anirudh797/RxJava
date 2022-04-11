package main.java;

import io.reactivex.rxjava3.core.Observable;

public class SupressingOperators {

    public static void main(String [] args){

        Observable.just("Alpha","Beta","Anirudh").filter(i->i.length()>5)
                .subscribe(s->System.out.println(s));
    }
}

class DistinctUntilChanged{
    //ignores consecutive duplicate emissions
    public static  void main(String [] args){

        Observable.just("a","a","b","c","a").distinctUntilChanged().subscribe(
                s->System.out.println(s)
        );
    }
}


class elementAt{
    //to get the element at the specified index
    public static  void main(String [] args){

        Observable.just("a","a","b","c","a").elementAt(2).subscribe(
                s->System.out.println(s)
        );
    }
}
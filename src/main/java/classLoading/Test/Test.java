package main.java.classLoading.Test;

public class Test {
    public static void main(String[] args) {
        MyClass[] a = new MyClass[5];
        System.out.println(a[0].x);
    }


}
class MyClass{
    static final int x = 10 ;
}

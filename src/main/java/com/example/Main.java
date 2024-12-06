package com.example;

import com.example.classLoader.JavaClassParser;
public class Main {
    public static void main(String[] args) {
        JavaClassParser parser = new JavaClassParser();
        parser.parse("target\\classes\\com\\example\\demos\\Test.class");
    }
}
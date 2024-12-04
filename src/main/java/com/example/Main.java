package com.example;

import org.apache.bcel.classfile.*;

import com.example.classLoader.JavaClassParser;
public class Main {
    public static void main(String[] args) {
        JavaClassParser.parse("target\\classes\\com\\example\\demos\\Test.class");
    }
}
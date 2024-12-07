package com.example;

import org.apache.bcel.classfile.Method;

import com.example.classLoader.JavaClassInfo;
import com.example.classLoader.JavaClassParser;
import com.example.execution.Executer;
import com.example.execution.ExecutionEngine;
public class Main {
    public static void main(String[] args) {
        JavaClassParser parser = new JavaClassParser();
        parser.parse("target\\classes\\com\\example\\demos\\Test.class");
        JavaClassInfo classInfo = parser
        .getMethodArea()
        .getClass("com.example.demos.Test");
        Method main = Executer.findMainMethod(classInfo);
        ExecutionEngine.executeMethod(main);
    }
}
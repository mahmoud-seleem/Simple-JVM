package com.example;

import java.util.Scanner;

import org.apache.bcel.classfile.Method;

import com.example.classLoader.JavaClassInfo;
import com.example.classLoader.JavaClassLoader;
import com.example.classLoader.JavaClassParser;
import com.example.execution.Executer;
import com.example.execution.ExecutionEngine;
public class Main {
    public static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        System.out.println("Starting our SIMPLE JVM :) ");
        System.out.println("---------------------------");
        System.out.println("please enter the directory Path the press Enter.");
        String basePath = input.nextLine();
        System.out.println("Please enter the class name to start execution.");
        String className = input.nextLine();
        System.out.println("-------------------------------");
        JavaClassLoader loader = new JavaClassLoader(basePath);
        JavaClassInfo classInfo = loader.loadClass(className);
        Method main = Executer.findMainMethod(classInfo);
        ExecutionEngine.executeMethod(main);
        // System.out.println(className);
        // Method[] methods = classInfo.getParsedClass().getMethods();
        // for (Method m : methods){
        //     System.out.println(m.getName());
        // }
        
    }

    public static void printArray(Object[] a){
        for (Object o : a){
            System.out.println(o);
        }
    }
}
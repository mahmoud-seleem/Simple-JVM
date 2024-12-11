package com.example;

import java.util.Scanner;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.LocalVariable;
import org.apache.bcel.classfile.LocalVariableTable;
import org.apache.bcel.classfile.Method;
import com.example.classLoader.JavaClassInfo;
import com.example.classLoader.JavaClassLoader;
import com.example.classLoader.JavaClassParser;
import com.example.execution.Executer;
import com.example.execution.ExecutionEngine;
import com.example.runtimeAreas.threads.JavaThread;
import com.example.runtimeAreas.threads.StackFrame;
// @SpringBootApplication
public class Main {
    public static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        //SpringApplication.run(Main.class, args);
        // System.out.println("Starting our SIMPLE JVM :) ");
        // System.out.println("---------------------------");
        // System.out.println("please enter the directory Path the press Enter.");
        // String basePath = input.nextLine();
        // System.out.println("Please enter the class name to start execution.");
        // String className = input.nextLine();
        // System.out.println("-------------------------------");
        // JavaClassLoader loader = new JavaClassLoader("D:\\backend-development\\JAVA\\jvm\\target\\classes\\com\\example\\demos\\Test.class");
        // JavaClassInfo classInfo = loader.loadClass("D:\\backend-development\\JAVA\\jvm\\target\\classes\\com\\example\\demos\\Test.class");
        // Method main = Executer.findMainMethod(classInfo);
        // JavaThread mainThread = new JavaThread();
        // ExecutionEngine.callMethod(mainThread, main,new Object[0]);
        // ExecutionEngine.executeMethod(mainThread,main);    
        JavaClass javaClass = new ClassParser("D:\\backend-development\\JAVA\\jvm\\target\\classes\\com\\example\\demos\\Test.class")
                                .parse();
//        System.out.println("hello");
    }    
}
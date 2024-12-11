package com.example.utils;

import java.util.Stack;

import com.example.runtimeAreas.threads.StackFrame;

public class Printing {
    public static void printArray(Object[] a){
        System.out.println("---------------------");
        for (Object o : a){
            System.out.println(o);
        }
        System.out.println("---------------------");
    }

    public static void printFrame(StackFrame frame){
        System.out.println("frame local variables");
        printArray(frame.getLocalVars());
        System.out.println("frame data");
        printArray(frame.getFrameData());
        System.out.println("frame operand stack");
        printArray(frame.getOperandStack().toArray());
    }
}

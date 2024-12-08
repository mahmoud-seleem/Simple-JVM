package com.example.execution;

import org.apache.bcel.classfile.Method;

import com.example.runtimeAreas.threads.JavaThread;
import com.example.runtimeAreas.threads.StackFrame;

public class InstructionsLibrary {
    // pushing value to stack
    public static void interpretByeCode(byte byteCode, JavaThread thread, Method method) {
        StackFrame currentFrame = thread.getCurrentFrame();
        
    }

    public static void iconst_0(StackFrame frame) {
        frame.push((int) 0);
    }

    public static void iconst_1(StackFrame frame) {
        frame.push((int) 1);
    }

    public static void iconst_2(StackFrame frame) {
        frame.push((int) 2);
    }

    public static void iconst_3(StackFrame frame) {
        frame.push((int) 3);
    }

    public static void iconst_4(StackFrame frame) {
        frame.push((int) 4);
    }

    public static void iconst_5(StackFrame frame) {
        frame.push((int) 5);
    }

    public static void iconst_m1(StackFrame frame) {
        frame.push((int) -1);
    }
    public static void iload(int index,StackFrame frame){
        frame.push(frame.getLocalAt(index));
    }
    public static void iload_0(StackFrame frame){
        frame.push(frame.getLocalAt(0));
    } 
    public static void iload_1(StackFrame frame){
        frame.push(frame.getLocalAt(1));
    } 
    public static void iload_2(StackFrame frame){
        frame.push(frame.getLocalAt(2));
    } 
    public static void iload_3(StackFrame frame){
        frame.push(frame.getLocalAt(3));
    } 
    public static void istore(int index,StackFrame frame){
        frame.setLocalAt(frame.pop(),index);
    } 
    public static void istore_0(StackFrame frame){
        frame.setLocalAt(frame.pop(),0);
    } 
    public static void istore_1(StackFrame frame){
        frame.setLocalAt(frame.pop(),1);
    } 
    public static void istore_2(StackFrame frame){
        frame.setLocalAt(frame.pop(),2);
    } 
    public static void istore_3(StackFrame frame){
        frame.setLocalAt(frame.pop(),3);
    } 


}

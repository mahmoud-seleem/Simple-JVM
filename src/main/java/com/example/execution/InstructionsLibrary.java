package com.example.execution;

import com.example.runtimeAreas.threads.StackFrame;

public class InstructionsLibrary {
    // pushing value to stack 
    public static void iconst_0(StackFrame frame){
        frame.push((int)0);
    }
}

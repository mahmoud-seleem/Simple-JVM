package com.example.runtimeAreas.threads;

import java.util.Stack;

public class JavaThread {
    private final Stack<StackFrame> stack = new Stack<>();

    public StackFrame createStackFrame(int localSize){
        StackFrame newFrame = new StackFrame(localSize);
        stack.push(newFrame);
        return newFrame;
    }

    public StackFrame removeStackFrame(){
        return stack.pop();
    }
    public StackFrame getCurrentFrame(){
        return stack.peek();
    }
}

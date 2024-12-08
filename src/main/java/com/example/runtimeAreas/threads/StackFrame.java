package com.example.runtimeAreas.threads;

import java.util.Stack;

public class StackFrame { 
    private final Object[] localVars;
    private final Stack<Object> operandStack = new Stack<>();
    private final Object[] frameData = new Object[3];

    public StackFrame(int localSize){
        this.localVars = new Object[localSize];
    }

    public void push(Object object){
        this.operandStack.push(object);
    }
    public Object pop(){
        return this.operandStack.pop();
    }

    public void setLocalAt(Object object,int index){
        this.localVars[index] = object;
    }

    public Object getLocalAt(int index){
        return this.localVars[index];
    }

    public void setFrameDateAt(Object object , int index){
        this.frameData[index] = object;
    }

    public Object getFrameDataAt(int index){
        return frameData[index];
    }
    public Object[] getLocals(){
        return localVars;
    }
    public Stack<Object> getOperandStack(){
        return operandStack;
    }
    public Object peek(){
        return operandStack.peek();
    }
}

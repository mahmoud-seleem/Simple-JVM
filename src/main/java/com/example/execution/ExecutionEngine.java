package com.example.execution;

import org.apache.bcel.classfile.Method;

import com.example.runtimeAreas.threads.JavaThread;
import com.example.runtimeAreas.threads.StackFrame;
import com.example.utils.Printing;
import static com.example.execution.InstructionsLibrary.*;

public class ExecutionEngine {
    public static void executeMethod(JavaThread thread,Method method) {
            byte[] byteCode = method.getCode().getCode();
            for (int i = 0 ; i < byteCode.length ;i++){
                switch (byteCode[i]) {
                    case 3:
                        iconst_0(thread.getCurrentFrame());
                        break;
                    default:
                        break;
                }
                Printing.printArray(thread.getCurrentFrame().getOperandStack().toArray());
            }
    }

    // method for creating the frame to a new method and pass the args to it.
    public static void callMethod(JavaThread thread ,Method method,Object[] args){
        
        // creation of the stack for the new method in the same thread.
        StackFrame currentFrame = thread.createStackFrame(method
            .getLocalVariableTable()
            .getTableLength());

        // passing args to it.
        if(method.getName().equals("main")){
            passArgs(args, currentFrame.getLocals(), true);
        }else{
            // code for any static method passing args 
        }
        Printing.printArray(currentFrame.getLocals());
    }

    private static void passArgs(Object[] callerArgs,Object[] calledLocals,boolean isStatic){
        int index ;
        if (isStatic){
            index = 0;
        }else{
            index = 1;
        } 
        for (Object object : callerArgs){
         calledLocals[index] = object;   
        }
    }
}

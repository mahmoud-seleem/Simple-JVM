package com.example.execution;

import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.Instruction;
import org.apache.bcel.generic.InstructionFactory;

public class ExecutionEngine {
    public static void executeMethod(Method method) {
        byte[] byteCode = method.getCode().getCode();
        for (byte b : byteCode){
            System.out.println(b);
        }
    }
}

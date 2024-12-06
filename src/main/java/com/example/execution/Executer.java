package com.example.execution;

import org.apache.bcel.classfile.Method;

import com.example.classLoader.JavaClassInfo;

public class Executer {
    
    public static Method findMainMethod(JavaClassInfo classInfo){
        Method[] classMethods = classInfo.getParsedClass().getMethods();
        for (Method method : classMethods){
            if (method.getName().equals("main")) {
                return method;
            }else {
                return method;
            }
        }
    }
}

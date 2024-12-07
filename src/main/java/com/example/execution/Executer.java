package com.example.execution;

import org.apache.bcel.classfile.Method;

import com.example.classLoader.JavaClassInfo;

public class Executer {
    
    public static Method findMainMethod(JavaClassInfo classInfo){
        Method[] classMethods = classInfo.getParsedClass().getMethods();
        Method mainMehtod = null; 
        for (Method method : classMethods){
            if (method.getName().equals("main")) {
                mainMehtod = method;
                return mainMehtod;
            }
        }
        return mainMehtod;
    }
}

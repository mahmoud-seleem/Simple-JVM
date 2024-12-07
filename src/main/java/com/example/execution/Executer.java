package com.example.execution;

import org.apache.bcel.classfile.Method;

import com.example.classLoader.JavaClassInfo;

public class Executer {
    
    public static Method findMainMethod(JavaClassInfo classInfo) throws NoSuchMethodException{
        if (classInfo != null ){
            Method[] classMethods = classInfo.getParsedClass().getMethods();
            Method mainMehtod = null; 
            for (Method method : classMethods){
                if (method.getName().equals("main")) {
                    mainMehtod = method;
                    return mainMehtod;
                }
            }
            throw new NoSuchMethodException("can't find main method");
            
        }
}

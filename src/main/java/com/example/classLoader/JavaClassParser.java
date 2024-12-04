package com.example.classLoader;

import org.apache.bcel.classfile.*;

public class JavaClassParser {
    public static boolean parse(String classPath){
        try{
            ClassParser parser = new ClassParser(classPath);
            JavaClass javaClass = parser.parse();
            System.out.println(javaClass.getMethods()[0].getName());
        }catch(Exception e){
            System.out.println("can't find the class");
        }
        return true;
    }
}

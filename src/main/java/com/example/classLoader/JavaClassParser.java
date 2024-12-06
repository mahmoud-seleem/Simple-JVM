package com.example.classLoader;

import org.apache.bcel.classfile.*;

import com.example.runtimeAreas.methodAreas.ClassLoaderMethodArea;

public class JavaClassParser {
    public static boolean parse(String classPath){
        try{
            ClassParser parser = new ClassParser(classPath);
            JavaClass javaClass = parser.parse();
            System.out.println(javaClass.getClassName());
            ClassLoaderMethodArea parserMethodArea = new ClassLoaderMethodArea();
            parserMethodArea.addClass(javaClass.getClassName(), javaClass);
            Object[] classesNames = parserMethodArea.getAllClassesNames();
            for (Object name : classesNames){
                System.out.println(name.toString());
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return true;
    }
}

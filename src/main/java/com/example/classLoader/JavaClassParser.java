package com.example.classLoader;

import org.apache.bcel.classfile.*;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.MethodGen;

import com.example.runtimeAreas.methodAreas.ClassLoaderMethodArea;

public class JavaClassParser {
    public static JavaClass parse(String classPath) {
        ClassParser parser;
        JavaClass javaClass = null;
        try {
            parser = new ClassParser(classPath);
            javaClass = parser.parse();
            return javaClass;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            parser = null;
        }
        return javaClass;
    }
}

package com.example.classLoader;

import org.apache.bcel.classfile.*;

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

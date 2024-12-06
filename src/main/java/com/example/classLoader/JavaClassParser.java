package com.example.classLoader;

import org.apache.bcel.classfile.*;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.MethodGen;

import com.example.runtimeAreas.methodAreas.ClassLoaderMethodArea;

public class JavaClassParser {
    private final ClassLoaderMethodArea parserMethodArea = new ClassLoaderMethodArea();
    public boolean parse(String classPath){
        ClassParser parser;
        try{
            parser = new ClassParser(classPath);
            JavaClass javaClass = parser.parse();
            parserMethodArea.addClass(
                javaClass.getClassName(),
                new JavaClassInfo(javaClass,this));
                // ConstantPoolGen cp = new ConstantPoolGen(javaClass.getConstantPool());
                // MethodGen methodGen = new MethodGen(javaClass.getMethods()[0], javaClass.getClassName(), cp);
            }
            catch(Exception e){
            System.out.println(e);
        }finally{
            parser = null;
        }
        return true;
    }
}

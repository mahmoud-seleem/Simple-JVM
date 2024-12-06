package com.example.classLoader;

import org.apache.bcel.classfile.JavaClass;

public class JavaClassInfo  {
    private JavaClass parsedClass;
    private JavaClassParser classLoader;

    public JavaClassInfo(){

    }
    public JavaClassInfo(JavaClass javaClass, JavaClassParser classLoader){
        this.parsedClass = javaClass;
        this.classLoader = classLoader;
    }
    public JavaClass getParsedClass() {
        return parsedClass;
    }
    public void setParsedClass(JavaClass parsedClass) {
        this.parsedClass = parsedClass;
    }
    public JavaClassParser getClassLoader() {
        return classLoader;
    }
    public void setClassLoader(JavaClassParser classLoader) {
        this.classLoader = classLoader;
    }
        
}

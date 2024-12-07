package com.example.classLoader;

import org.apache.bcel.classfile.JavaClass;

public class JavaClassInfo  {
    private JavaClass parsedClass;
    private JavaClassLoader classLoader;

    public JavaClassInfo(){

    }
    public JavaClassInfo(JavaClass javaClass, JavaClassLoader classLoader){
        this.parsedClass = javaClass;
        this.classLoader = classLoader;
    }
    public JavaClass getParsedClass() {
        return parsedClass;
    }
    public void setParsedClass(JavaClass parsedClass) {
        this.parsedClass = parsedClass;
    }
    public JavaClassLoader getClassLoader() {
        return classLoader;
    }
    public void setClassLoader(JavaClassLoader classLoader) {
        this.classLoader = classLoader;
    }
        
}

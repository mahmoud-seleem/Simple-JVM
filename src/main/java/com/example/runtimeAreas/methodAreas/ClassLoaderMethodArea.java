package com.example.runtimeAreas.methodAreas;

import java.util.HashMap;
import java.util.Map;

import org.apache.bcel.classfile.JavaClass;

public class ClassLoaderMethodArea {
    private final Map<String,JavaClass> methodArea = new HashMap<>();
    public void addClass(String className,JavaClass clz){
        methodArea.put(className, clz);
    }
    public JavaClass getClass(String className){
        return methodArea.get(className);
    }
    public Object[] getAllClassesNames(){
        return methodArea.keySet().toArray();
    }
}

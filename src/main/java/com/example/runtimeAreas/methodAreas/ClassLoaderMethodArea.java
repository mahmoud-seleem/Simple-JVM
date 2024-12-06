package com.example.runtimeAreas.methodAreas;

import java.util.HashMap;
import java.util.Map;


import com.example.classLoader.JavaClassInfo;

public class ClassLoaderMethodArea {
    private final Map<String,JavaClassInfo> methodArea = new HashMap<>();
    
    public void addClass(String className,JavaClassInfo clz){
        methodArea.put(className, clz);
    }

    public JavaClassInfo removeClass(String className){
        return methodArea.remove(className);
    }
    public JavaClassInfo getClass(String className){
        return methodArea.get(className);
    }
    public Object[] getAllClassesNames(){
        return methodArea.keySet().toArray();
    }

}

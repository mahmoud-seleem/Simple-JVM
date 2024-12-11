package com.example.classLoader;

import org.apache.bcel.classfile.JavaClass;

import com.example.runtimeAreas.methodAreas.ClassLoaderMethodArea;

// assuming all the classes is in the same directory 
// as the loader will now search for all .class files only in the same directory 
// we start with the class that contains the main method.
public class JavaClassLoader {

    private final ClassLoaderMethodArea loaderMethodArea = new ClassLoaderMethodArea();
    private final String BASE_PATH;

    public JavaClassLoader(String basePath) {
        this.BASE_PATH = basePath;
    }

    public JavaClassInfo loadClass(String className) throws Exception{
        // String classPath = new StringBuffer()
        //         .append(BASE_PATH)
        //         .append("\\")
        //         .append(className)
        //         .append(".class")
        //         .toString();
                //classPath = classPath.replace("\\", ".");
        JavaClass javaClass = JavaClassParser.parse(className);
        JavaClassInfo classInfo = null;
        if (javaClass != null){
            classInfo = new JavaClassInfo(javaClass, this);
            loaderMethodArea.addClass(
                    javaClass.getClassName(),
                    classInfo);
            return classInfo;
                }
        throw new Exception("hi");
    }

    public ClassLoaderMethodArea getMethodArea() {
        return this.loaderMethodArea;
    }

    // private String searchForClass(String className){

    // }
}

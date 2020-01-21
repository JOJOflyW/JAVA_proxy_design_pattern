package com.wfj.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectServiceImpl {
    private String name;
    public ReflectServiceImpl(String name){
        this.name = name;
    }
    public ReflectServiceImpl(){

    }
    public void sayHello(){
        System.err.println("hello"+name);
    }
    public Object reflectMethod(){
        Object returnObj = null;

        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            Method method = ReflectServiceImpl.class.getMethod("sayHello",String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    return returnObj;
    }
    //通过反射的方法构建它
    public ReflectServiceImpl getInstance(){
        ReflectServiceImpl object = null;
        try {
            //不带参的构建
            // object = (ReflectServiceImpl) Class.forName("com.wfj.reflect.ReflectServiceImpl").newInstance();
            //带参的构建
             object = (ReflectServiceImpl) Class.forName("com.wfj.reflect.ReflectServiceImpl").
                     getConstructor(String.class).newInstance("张三");

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }
    public Object reflect(){
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl)Class.
                    forName("com.wfj.reflect.ReflectServiceImpl").
                    getConstructor(String.class).newInstance("张三");
            Method method = object.getClass().getMethod("sayHello",String.class);
            method.invoke(object,"张三");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

}

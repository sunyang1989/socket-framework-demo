package com.sun.simple.bean;

import java.io.Serializable;

/**
 * netty 传输bean
 * @author yang.sun
 * @date 2016/5/13
 */
public class Person implements Serializable {

    private String name;
    private double age;

    public Person(String name, double age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

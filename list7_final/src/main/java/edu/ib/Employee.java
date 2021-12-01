package edu.ib;

public class Employee {
    private final String name;
    private final String sex;
    private final int age;
    private int height;
    private int mass;

    public Employee(String name, String sex, int age, int height, int mass) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.mass = mass;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", mass=" + mass +
                '}';
    }

    public double earnings(){
        return 0;
    }

    public double calcBMI(){
        //zamiana funtów na kg i cali na m
        return (0.45359237*mass)/Math.pow(0.0254*height,2);
    }

    public int getAge() {
        return age;
    }
}

package edu.ib;

public class Worker extends Employee{
    private double baseSalary;
    private double timeRate;

    public Worker(String name, String sex, int age, int height, int mass) {
        super(name, sex, age, height, mass);
    }

    public void defineErnings(double baseSalary, double timeRate) {
        if (baseSalary < 0)
            throw new IllegalArgumentException("salary must be greater than 0");
//        if (timeRate < 0 || timeRate >1.0)
//            throw new IllegalArgumentException("wrong work time rate");
        this.timeRate=timeRate;
        this.baseSalary=baseSalary;
    }

    @Override
    public double earnings(){
        return baseSalary*timeRate;
    }

    @Override
    public String toString() {
        String oldPart=super.toString();
        oldPart=oldPart.substring(0,oldPart.length()-1);
        String newPart=", baseSalary=" + baseSalary + ", timeRate=" + timeRate  + '}';
        return oldPart.concat(newPart);
    }
}

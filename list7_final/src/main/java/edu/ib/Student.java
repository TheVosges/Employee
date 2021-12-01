package edu.ib;

public class Student extends Employee{
    public double intershipEarnings;
    public double hoursInMonth;

    public Student(String name, String sex, int age, int height, int mass) {
        super(name, sex, age, height, mass);
    }

    public void defineErnings(double intershipEarnings, double hoursInMonth) {
        if (intershipEarnings < 0)
            throw new IllegalArgumentException("internship earnings must be greater than 0");
        if (hoursInMonth < 0)
            throw new IllegalArgumentException("wrong time provided");
        this.hoursInMonth=hoursInMonth;
        this.intershipEarnings=intershipEarnings;
    }

    @Override
    public double earnings(){
        return hoursInMonth*intershipEarnings;
    }

    @Override
    public String toString() {
        String oldPart=super.toString();
        oldPart=oldPart.substring(0,oldPart.length()-1);
        String newPart=", intershipEarnings=" + intershipEarnings + ", hoursInMonth=" + hoursInMonth  + '}';
        return oldPart.concat(newPart);
    }

}

package edu.ib;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    public static ArrayList importData(String path){
        ArrayList<Employee> employees = new ArrayList<Employee>();
        try {

            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(path);

            // create csvReader object passing
            // file reader as a parameter
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    String[] row = cell.split(String.valueOf(';'));
                    if (row[5].contains("Student")){
                        Student student = new Student(row[0], row[1],Integer.parseInt(row[2]), Integer.parseInt(row[3]), Integer.parseInt(row[4]));
                        employees.add(student);
                        //(Math.random()* (max - min + 1) + min) - losowanie int od max do min
                        student.defineErnings((int) (Math.random()* (25 - 19 + 1) +19), (int) (Math.random()* (40 - 20 + 1) +20));
                        }
                    else if (row[5].contains("Worker")){
                        Worker worker = new Worker(row[0], row[1], Integer.parseInt(row[2]), Integer.parseInt(row[3]), Integer.parseInt(row[4]));
                        employees.add(worker);
                        // UWAGA na dzielenie całkowite w timeRate
                        worker.defineErnings((int) (Math.random()* (5000 - 2000 + 1) +2000), ((double) ( Math.round(  (Math.random()* (1 - 0.2) + 0.2) * 100))/100));
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return employees;
    }

    //a) zwracającą średnią wieku wszystkich pracowników
    public static double getAvgAge(ArrayList<Employee> employees){
        double avgAge = 0;
        int count = 0;
        for (Employee employee : employees){
            avgAge += employee.getAge();
        }
        return avgAge/employees.size();
    }

    // b) zwracającą procent pracowników, którzy są studentami
    public static double percentOfStudents(ArrayList<Employee> employees){
        double countWorkers = 0;
        double countStudents = 0;
        for (Employee employee : employees){
             if (employee instanceof Student) countStudents+=1;
             else if (employee instanceof Worker) countWorkers+=1;
        }
        return (countStudents/employees.size())*100;
    }

    // c) zwracającą najwyższą pensję pracownika
    public static double maxSalary(ArrayList<Employee> employees){
        double maxSalary = 0;
        for (Employee employee : employees){
            if (maxSalary < employee.earnings()) maxSalary = employee.earnings();
        }
        return maxSalary;
    }

    //d) zwracającą liczbę osób, których BMI wskazuje na prawidłową wagę (18,5–24,9)
    public static int checkHealth(ArrayList<Employee> employees){
        int countHealthy = 0;
        for (Employee employee : employees){
            if (employee.calcBMI() > 18.5 && employee.calcBMI() < 24.9) countHealthy ++;
        }
        return countHealthy;
    }

    public static void main(String[] args) {
        String path = "Lab7_biostats.csv";
        ArrayList<Employee> employees = importData(path);
        for (Employee employee : employees){
            System.out.println(employee.toString());
        }
        // a)
        System.out.println("a) " + getAvgAge(employees));

        // b)
        System.out.println("b) " + percentOfStudents(employees));

        // c)
        System.out.println("c) " + maxSalary(employees));

        // d)
        System.out.println("d) " + checkHealth(employees) + " out of " + employees.size());
    }
}

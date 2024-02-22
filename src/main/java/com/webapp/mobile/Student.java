package com.webapp.mobile;

import lombok.Data;

import java.util.Arrays;

import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class Student {
    private int id;
    private String name;
    private int salary;
    private int age;
    private String city;

    // Constructor

    public Student(int id, String name, int salary,int age,String city) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.city= city;
    }

    // Getter for salary
    public int getSalary() {
        return salary;
    }

    // Getter for name
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }



    public static void main(String[] args) {
        List<Student> std = Arrays.asList(
                new Student(1, "amit", 3000,20,"ranchi"),
                new Student(3, "sumit", 6000,22,"ramgarh"),
                new Student(4, "anil", 5000,25,"ranchi"),
                new Student(2, "sia", 6000,35,"chennai")
        );

        Map<Integer, List<Student>> val = std.stream()
                .collect(Collectors
                        .groupingBy(Student::getSalary,() -> new TreeMap<>(Comparator.reverseOrder()), // Use TreeMap with custom comparator for descending order
                        Collectors.toList()));
        val.forEach((salary,studentlist)->{
            System.out.println(salary+":"+studentlist);
        });

    }
}

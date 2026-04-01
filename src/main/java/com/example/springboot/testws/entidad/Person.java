package com.example.springboot.testws.entidad;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "persona")
@XmlType(propOrder = {"id", "fullName", "age", "salario"})
public class Person {

    private int id;
    private String fullName;
    private int age;
    private double salario;

    private static final double SALARIO_MINIMO = 1750905;

    public Person() {}

    @XmlElement
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @XmlElement
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    @XmlElement
    public int getAge() { return age; }
    public void setAge(int age) {
        this.age = age;
        this.salario = age * SALARIO_MINIMO / 3;
    }

    @XmlElement
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
}
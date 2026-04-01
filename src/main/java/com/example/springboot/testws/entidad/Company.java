package com.example.springboot.testws.entidad;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "company")
public class Company {

    private String nombre;
    private double valor;

    public Company() {}

    public Company(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    @XmlElement
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @XmlElement
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
}
package com.example.springboot.testws.services;

import com.example.springboot.testws.entidad.Person;
import com.example.springboot.testws.entidad.Company;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.*;

@Path("service")
public class Service {

    private static Map<Integer, Person> persons = new HashMap<>();

    static {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            int id = i + 1;
            person.setId(id);
            person.setFullName("My wonderfull Person " + id);
            person.setAge(new Random().nextInt(40) + 1);
            persons.put(id, person);
        }
    }

    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id") int id) {
        return persons.get(id);
    }

    @GET
    @Path("/getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJson(@PathParam("id") int id) {
        return persons.get(id);
    }

    @GET
    @Path("/getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML() {
        return new ArrayList<>(persons.values());
    }

    @GET
    @Path("/getAllPersonsInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonsInJson() {
        return new ArrayList<>(persons.values());
    }

    @POST
    @Path("/agregar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean agregar(Person person) {
        persons.put(person.getId(), person);
        return true;
    }

    @POST
    @Path("/agregarPersonas")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Person> agregarPersonas(List<Person> nuevas) {
        for (Person p : nuevas) {
            persons.put(p.getId(), p);
        }
        return new ArrayList<>(persons.values());
    }

    @POST
    @Path("/addPersonInJson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPersonInJson(Person person) {
        persons.put(person.getId(), person);
        return person;
    }

    @GET
    @Path("/getAverageSalaryInXML")
    @Produces(MediaType.APPLICATION_XML)
    public Company getAverageSalaryInXML() {
        double total = 0;
        for (Person p : persons.values()) {
            total += p.getSalario();
        }
        double promedio = persons.isEmpty() ? 0 : total / persons.size();
        return new Company("Salario Promedio", promedio);
    }

    @GET
    @Path("/getAverageSalaryInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public Company getAverageSalaryInJson() {
        double total = 0;
        for (Person p : persons.values()) {
            total += p.getSalario();
        }
        double promedio = persons.isEmpty() ? 0 : total / persons.size();
        return new Company("Salario Promedio", promedio);
    }

    @GET
    @Path("/getSumSalaryInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public Company getSumSalaryInJson() {
        double total = 0;
        for (Person p : persons.values()) {
            total += p.getSalario();
        }
        return new Company("Suma de Salarios", total);
    }
}
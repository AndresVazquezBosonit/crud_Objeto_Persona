package com.crud.objectPerson.entity;

import javax.persistence.*;

@Entity
@Table(name= "Persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nombre;
    private String poblacion;
    private int edad;

    public Persona() {
    }

    public Persona(Long id, String nombre, String poblacion, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.edad = edad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

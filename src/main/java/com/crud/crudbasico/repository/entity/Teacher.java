package com.crud.crudbasico.repository.entity;

import com.crud.crudbasico.dto.TeacherDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // Anotacion entidad, es el objeto que represent la base de datos
// entidad es una tabla de la base de datos
public class Teacher {
    /**
     * nombres name
     * apellidos last name
     * cedula  id
     * edad age
     * materia course
     */
    @Id // Clave de la clase
    private Integer id; //De tipo envolvente

    @Column(name = "NAME_TEACHER", nullable = false) // nullable no admite campo nulo
    private String name; // Los atributos de la clase o de la entidad
    private String lastName;
    private String course; // TODO El curso debe ser una lista
    private Integer age;

    // TODO cedula, nombre y apellido son campos obligatorios
    public Teacher(Integer id, String name, String lastName, String course, Integer age) { // Constructor de la clase
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.course = course;
        this.age = age;
    }

    public Teacher(Integer id) { // Instancia vacia
        this.id = id;
    }

    public Teacher() {
    }

    // Getter y setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lasName) {
        this.lastName = lasName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    // Objeto de tipo TeacherDTO que tiene id y nombre y otros
    // DTO para que no conozcan lo que hay en la capa de datos
    public Teacher(TeacherDTO teacherDTO) {
        this.id = teacherDTO.getId();
        this.name = teacherDTO.getName();
        this.lastName = teacherDTO.getLastName();
        this.course = teacherDTO.getCourse();
        this.age = teacherDTO.getAge();
    }
}

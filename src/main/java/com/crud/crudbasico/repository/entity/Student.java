package com.crud.crudbasico.repository.entity;


import com.crud.crudbasico.dto.CourseDTO;
import com.crud.crudbasico.dto.StudentDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    /**
     * name
     * lastName
     * dateOfBirth
     * id
     * age
     * course -->  TODO Es una entidad
     */


    @Id
    private Integer id;

    @Column(name = "NAME_ESTUDIANTE", nullable = false)
    private String name;
    private String lastName;
    private String dateOfBirth;
    private Integer age; //  todo debe ser un dato calculado a partir de la fecha
    // private List<CourseDTO> courseList = new List<CourseDTO>(); // todo esto esta mal instanciado
// TODO todos los campos del alumno son obligatorios
    @ManyToOne() // Relación de muchos cursos a un solo profesor
    @JoinColumn(name = "student_course")
    Course course; // = new ArrayList<Teacher>();

    public Student(Integer id, String name, String lastName, String dateOfBirth, Integer age, Course course) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.course = course;
    }

    public Student() {
    }




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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student(StudentDTO studentDTO) {
        this.id = studentDTO.getId();
        this.dateOfBirth = studentDTO.getDateOfBirth();
        this.age = studentDTO.getAge();
        this.name = studentDTO.getName();
        this.lastName = studentDTO.getLastName();
        this.course = studentDTO.getCourse();

    }
}

package com.crud.crudbasico.repository.entity;

import com.crud.crudbasico.dto.TeacherDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Teacher {
    /**
     * nombres name
     * apellidos last name
     * cedula  id
     * edad age
     * materia course
     *
      */
    @Id
    private Integer id;

    @Column(name = "NAME_TEACHER", nullable = false, insertable = false, updatable = false)
    private String name, lasName, course;
    private Integer  age;
    public Teacher(Integer id, String name, String lasName, String course, Integer age){
        this.id = id;
        this.name = name;
        this.lasName = lasName;
        this.course = course;
        this.age = age;
    }
    public Teacher(){

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

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
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

    public Teacher(TeacherDTO teacherDTO){
        this.id = teacherDTO.getId();
        this.name = teacherDTO.getName();
        this.lasName = teacherDTO.getLasName();
        this.course = teacherDTO.getCourse();
        this.age = teacherDTO.getAge();
    }
}

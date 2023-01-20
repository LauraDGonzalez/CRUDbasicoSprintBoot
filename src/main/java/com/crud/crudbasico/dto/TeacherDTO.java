package com.crud.crudbasico.dto;
import com.crud.crudbasico.repository.entity.Teacher;

public class TeacherDTO {
    private Integer id, age;
    private String name, lasName, course;

    public TeacherDTO(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public TeacherDTO(Teacher teacher){
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.lasName = teacher.getLasName();
        this.course = teacher.getCourse();
        this.age = teacher.getAge();


    }
}

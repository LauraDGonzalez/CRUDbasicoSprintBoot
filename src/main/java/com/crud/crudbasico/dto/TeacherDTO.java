package com.crud.crudbasico.dto;
import com.crud.crudbasico.repository.entity.Teacher;

// Los DTO proteger los datos de la BD y crear un medio de transporte seguiro sin necesidad de acceder a ellos directamente
public class TeacherDTO {
    private Integer id;
    private Integer age;
    private String name;
    private String lastName;



    public TeacherDTO(){

    }
    public TeacherDTO(Integer id){
        this.id = id;

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

    public String getLastName() {
        return lastName;
    }

    public void setLasName(String lasName) {
        this.lastName = lasName;
    }



    public TeacherDTO(Teacher teacher){
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.lastName = teacher.getLastName();

        this.age = teacher.getAge();


    }
}

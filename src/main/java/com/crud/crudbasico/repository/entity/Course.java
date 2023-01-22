package com.crud.crudbasico.repository.entity;

import com.crud.crudbasico.dto.CourseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Course {


    @Id
    private Integer id;

    @Column(name = "NAME_COURSE", nullable = false)
    private String student; // TODO esta es la relacion, debe ser una lista
    //private String teacher; // TODO esta es la relacion, debe ser una lista
    private Integer schedule; // Este es el horario del curso
    private String topic;  // Este es el tema del curso

    // TODO horario y tema son obligatorios

    @ManyToOne
    private Teacher teacher;
    public Course(Integer id, String student,  Integer schedule, String topic) {
        this.id = id;
        this.student = student;
       // this.teacher = teacher;
        this.schedule = schedule;
        this.topic = topic;
    }

    public Course() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }



    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    //Se crea DTO
    public Course(CourseDTO courseDTO) {
        this.id = courseDTO.getId();
        this.schedule = courseDTO.getSchedule();
        this.student = courseDTO.getStudent();
        this.topic = courseDTO.getTopic();
        //this.teacher = courseDTO.getTeacher();
    }
}

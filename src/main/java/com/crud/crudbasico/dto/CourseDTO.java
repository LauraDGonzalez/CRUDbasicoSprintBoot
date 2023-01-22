package com.crud.crudbasico.dto;

import com.crud.crudbasico.repository.entity.Course;


public class CourseDTO {

    private Integer id; // Este es el id de la materia, no lo dice en el texto
    private String student; // TODO esta es la relacion, debe ser una lista
    private String teacher; // TODO esta es la relacion, debe ser una lista
    private Integer schedule; // Este es el horario del curso
    private String topic;  // Este es el tema del curso

    public CourseDTO() {

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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
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

    public CourseDTO(Course course){
        this.student = course.getStudent();
        this.id = course.getId();
        this.schedule = course.getSchedule();
        //this.teacher = course .getTeacher();
        this.topic = course.getTopic();


    }
}

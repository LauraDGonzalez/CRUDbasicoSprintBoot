package com.crud.crudbasico.dto;

import com.crud.crudbasico.repository.entity.Course;
import com.crud.crudbasico.repository.entity.Student;
import com.crud.crudbasico.repository.entity.Teacher;

import java.util.List;


public class CourseDTO {

    private Integer id; // Este es el id de la materia, no lo dice en el texto

    private Teacher teacher; // TODO esta es la relacion, debe ser una lista
    private Integer schedule; // Este es el horario del curso
    private String topic;  // Este es el tema del curso

    List<Student> studentList;
    public CourseDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
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

        this.id = course.getId();
        this.schedule = course.getSchedule();
        this.teacher = course.getTeacher();
        this.topic = course.getTopic();
       this.studentList = course.getStudentList();


    }
}

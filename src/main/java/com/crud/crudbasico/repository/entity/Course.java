package com.crud.crudbasico.repository.entity;

import com.crud.crudbasico.dto.CourseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Course {


    @Id
    private Integer id;

    @Column(name = "NAME_COURSE", nullable = false)
    // TODO esta es la relacion, debe ser una lista
    //private String teacher; // TODO esta es la relacion, debe ser una lista
    private Integer schedule; // Este es el horario del curso
    private String topic;  // Este es el tema del curso
    // , orphanRemoval = true cuando eliminen esa entidad se eliminen los cursos
    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // todo esto deberia ser Many to One

    // join table para la relacion onetomany y para nombrar los atributos de la tabla de relacion
    //  @JoinTable(
    // name = "course_teacher",// como se va a llamar la tabla
    //  joinColumns = @JoinColumn(name = "course_id"),
    //  inverseJoinColumns = @JoinColumn(name = "teacher_id")
    //)
    @ManyToOne() // Relación de muchos cursos a un solo profesor
    @JsonIgnore
    @JoinColumn(name = "course_teacher")
    Teacher teacher; // = new ArrayList<Teacher>();
    // TODO horario y tema son obligatorios


    @OneToMany(mappedBy = "course")// Desde la clase course poder acceder a la lista de estudiantes
    @JsonIgnore
    List<Student> studentList;
    // Ejemplo de relación de uno a uno
    // @ManyToOne(cascade = CascadeType.ALL)// Permite hacer la persistencia, la actualización, la eliminacion a través del curso
    //@JoinColumn(name = "fk_teacher") // Indicamos que esta columna va a ser la llave foranea de la entidad profesor
    //private Teacher teacher;


    public Course(Integer id,  Teacher teacher, Integer schedule, String topic, List<Student> studentList) {
        this.id = id;
        this.teacher = teacher;
        this.schedule = schedule;
        this.topic = topic;
        this.studentList = studentList;
    }

    public Course() {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", schedule=" + schedule +
                ", topic='" + topic + '\'' +
                ", teacher=" + teacher +
                ", studentList=" + studentList +
                '}';
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
        this.topic = courseDTO.getTopic();
        this.teacher = courseDTO.getTeacher();
        this.studentList = courseDTO.getStudentList();
    }
}

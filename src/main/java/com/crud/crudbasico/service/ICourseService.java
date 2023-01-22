package com.crud.crudbasico.service;

import com.crud.crudbasico.dto.CourseDTO;

import java.util.List;

public interface ICourseService {

    /**
     * Método guardar
     *
     * @param course
     */
    void save(CourseDTO course);

    /**
     * Método para traer una lista de todos los cursos de la BD
     *
     * @return
     */
    List<CourseDTO> getAll();

    /**
     * Método para actualizar
     * @param course
     * @return
     */
    String update(CourseDTO course);

    /**
     * Métdodo para eliminar
     * @param id
     * @return
     */
    Boolean delete(Integer id);
}

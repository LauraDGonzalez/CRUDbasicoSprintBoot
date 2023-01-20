package com.crud.crudbasico.service;

import com.crud.crudbasico.dto.TeacherDTO;

import java.util.List;

// Esta interface me permite definir los métidos que voy  a necesitar para luego implementarlos
public interface IProfesorService {
    void save(TeacherDTO teacher); // Permite crear un nueva entidad para eso le enviamos una entidad al repositorio
    List<TeacherDTO> getAll(); // Va a traer una lista de todas las personas que se encuentran en la base de datos

    String update(TeacherDTO teacher); // Método actualizar

    Boolean delete(Integer id);

     // Método eliminar, debe recibir el id, buscar si existe y eliminar

}

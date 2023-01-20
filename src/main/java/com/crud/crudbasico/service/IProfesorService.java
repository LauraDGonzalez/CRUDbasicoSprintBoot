package com.crud.crudbasico.service;

import com.crud.crudbasico.dto.TeacherDTO;

import java.util.List;

public interface IProfesorService {
    void save(TeacherDTO teacher);
    List<TeacherDTO> getAll();

    String update(TeacherDTO teacher);
}

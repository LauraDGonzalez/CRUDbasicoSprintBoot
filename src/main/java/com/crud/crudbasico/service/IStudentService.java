package com.crud.crudbasico.service;

import com.crud.crudbasico.dto.StudentDTO;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface IStudentService {

    void save(StudentDTO studentDTO);
    List<StudentDTO> getAll();
    String update(StudentDTO studentDTO);
    Boolean delete(Integer id);
}

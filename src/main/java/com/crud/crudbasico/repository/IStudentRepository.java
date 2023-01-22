package com.crud.crudbasico.repository;

import com.crud.crudbasico.repository.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepository extends CrudRepository<Student, Integer> {


}

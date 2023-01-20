package com.crud.crudbasico.repository;

import com.crud.crudbasico.repository.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface IteacherRepository extends CrudRepository<Teacher, Integer> {
}

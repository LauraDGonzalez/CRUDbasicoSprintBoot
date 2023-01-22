package com.crud.crudbasico.repository;

import com.crud.crudbasico.repository.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface ICourseRepository extends CrudRepository<Course, Integer> {

}

package com.crud.crudbasico.repository;

import com.crud.crudbasico.repository.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ICourseRepository extends JpaRepository<Course, Integer> {

}

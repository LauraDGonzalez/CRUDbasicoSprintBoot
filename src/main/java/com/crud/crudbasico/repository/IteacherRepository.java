package com.crud.crudbasico.repository;

import com.crud.crudbasico.repository.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface IteacherRepository extends CrudRepository<Teacher, Integer> {
    // Esta interface permite separar la logica de negocio de la logica para acceder a la base de datos
    // IPersonaRepository se va a comunicar con la base de datos, se extiende de
    /**CrudRepository: Interfaz para operaciones CRUD genéricas en un repositorio para un tipo específico
     Recibe la entidad a la cual va a ser referencia y el tipo de id que se declaró
     */
}

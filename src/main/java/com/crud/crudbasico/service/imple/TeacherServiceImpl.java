package com.crud.crudbasico.service.imple;

import com.crud.crudbasico.dto.TeacherDTO;
import com.crud.crudbasico.repository.IteacherRepository;
import com.crud.crudbasico.repository.entity.Teacher;
import com.crud.crudbasico.service.IProfesorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Esta es la implementacion de la interface en esta clase


@Service // Indico que la clase va a ser un servicio
public class TeacherServiceImpl implements IProfesorService { // Heredando de la interface IPersonaService

    private  final IteacherRepository repository; // Se crea una implementacion de IPersonaRepository que es la interface para realizar el CRUD generico

    // Inyeccion de dependencias a traves del constructor
    public TeacherServiceImpl(IteacherRepository repository){ // El constructor no lo vamos a llamar, spring se encarga de obtener las dependencias que necesita el servicio
        this.repository = repository;
    }

    // Con el override estamos implementando los metodos de la interface
    @Override
    public void save(TeacherDTO teacher) {
       if (!repository.existsById(teacher.getId())){ // si la persona no existe guarda el
           repository.save(new Teacher(teacher));
       }

    }

    @Override
    public List<TeacherDTO> getAll() { // Para obtener una lista de los elementos de la entidad
        List<Teacher> list = (List<Teacher>) repository.findAll(); //
        return list.stream() // Flujo de trabajo para listar
                .map(TeacherDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public String update(TeacherDTO teacher) {
        Optional<Teacher> value = repository.findById(teacher.getId());
        if(value.isPresent()){ // Si existe ese valor permite la actualizacion
            repository.save(new Teacher(teacher));
            return "Update";
        }else {
            return "No exist";
        }
    }
}

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


@Service // Indico que la clase va a ser un servicio, que es un servicio y esta disponible para que cualquiera lo pueda usar
public class TeacherServiceImpl implements IProfesorService { // Heredando de la interface IPersonaService
// La clase repository es la que sabe guardar por eso se crea una instancia
    private  final IteacherRepository repository; // Se crea una implementacion de IPersonaRepository que es la interface para realizar el CRUD generico

    // Inyeccion de dependencias a traves del constructor
    public TeacherServiceImpl(IteacherRepository repository){ // El constructor no lo vamos a llamar, spring se encarga de obtener las dependencias que necesita el servicio
        this.repository = repository;
    }

    // Con el override estamos implementando los metodos de la interface
    @Override
    public void save(TeacherDTO teacher) { // Crear un elemento en la BD
       if (!repository.existsById(teacher.getId())){ // si la persona no existe guarda el
           repository.save(new Teacher(teacher));
       }

    }

    @Override
    public List<TeacherDTO> getAll() { // Para obtener una lista de los elementos de la entidad
        List<Teacher> list = (List<Teacher>) repository.findAll(); // repository.findAll(); Trae todas las personas que hay en la tabla
        // List<Teacher>) esta lista tiene todos los datos de la tabla es como si fuera castear
        return list.stream() // Flujo de trabajo para listar
                .map(TeacherDTO::new) // .map Cambia la operacion que hay en el objeto, crea una nueva entidad para cada TeacherDTO, por cada elemento la pasa una vez
                .collect(Collectors.toList()); // Esto se lo devuelve a la capa controlador
    }

    @Override
    public String update(TeacherDTO teacher) { // Permite actualizar un elemento de la BD

        Optional<Teacher> value = repository.findById(teacher.getId());
        if (value.isPresent()) { // Si existe ese valor permite la actualizacion
            repository.save(new Teacher(teacher));
            return "Se ha actualizado exitosamente el profesor";
        } else {
            return "No exist ese profesor";
        }
    }

    @Override
    public Boolean delete(Integer id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        } else{
            return false;
        }


    }


}

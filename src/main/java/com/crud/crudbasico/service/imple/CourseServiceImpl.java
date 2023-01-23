package com.crud.crudbasico.service.imple;


import com.crud.crudbasico.dto.CourseDTO;
import com.crud.crudbasico.dto.TeacherDTO;
import com.crud.crudbasico.repository.ICourseRepository;
import com.crud.crudbasico.repository.entity.Course;
import com.crud.crudbasico.repository.entity.Teacher;
import com.crud.crudbasico.service.ICourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements ICourseService {
    private final ICourseRepository repository;


    public CourseServiceImpl(ICourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(CourseDTO course) {
        if (!repository.existsById(course.getId())) { // si la persona no existe guarda el
            repository.save(new Course(course));
        }
    }

    @Override
    public List<CourseDTO> getAll() {
        List<Course> list =  repository.findAll(); // repository.findAll(); Trae todas las personas que hay en la tabla

        System.out.println(list.get(0).getStudentList());
        System.out.println(list.get(0).getTeacher());
        // List<Teacher>) esta lista tiene todos los datos de la tabla es como si fuera castear
        System.out.println( list.toString());

       return list.stream() // Flujo de trabajo para listar
                .map(CourseDTO::new) // .map Cambia la operacion que hay en el objeto, crea una nueva entidad para cada TeacherDTO, por cada elemento la pasa una vez
                .collect(Collectors.toList());
    }

    @Override
    public String update(CourseDTO course) {
        Optional<Course> value = repository.findById(course.getId());
        if (value.isPresent()) { // Si existe ese valor permite la actualizacion
            repository.save(new Course(course));
            return "Se ha actualizado exitosamente el curso";
        } else {
            return "No existe ese curso";
        }
    }

    @Override
    public Boolean delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

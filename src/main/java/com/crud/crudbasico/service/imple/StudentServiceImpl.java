package com.crud.crudbasico.service.imple;

import com.crud.crudbasico.dto.StudentDTO;
import com.crud.crudbasico.dto.StudentPruebaDTO;
import com.crud.crudbasico.repository.IStudentRepository;
import com.crud.crudbasico.repository.entity.Student;
import com.crud.crudbasico.service.ICourseService;
import com.crud.crudbasico.service.IStudentService;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements IStudentService {

    public final IStudentRepository repository;

    /**
     * Inyección de dependencias para el servicio del CRUD
     *
     * @param repository
     */
    public StudentServiceImpl(IStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(StudentDTO student) {

        if (!repository.existsById(student.getId())) {// TODO voy acá, tengo una duda sobre si es student solo o studenDTO
            repository.save(new Student(student));
        }
    }

    @Override
    public List<StudentPruebaDTO> getAll() {
        List<Student> list = (List<Student>) repository.findAll();
        System.out.println(list.get(0).getCourse());
        return list.stream() // TODO estudiar los flujos de trabajo
                .map(StudentPruebaDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public String update(StudentDTO student) {

        Optional<Student> value = repository.findById(student.getId()); //TODO consultar sobre el Optional
        if (value.isPresent()) {
            repository.save(new Student(student));
            return " Se ha actualizado exitosamente la materia";
        } else {
            return "No existe esa materia";

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

package com.crud.crudbasico.service.imple;

import com.crud.crudbasico.dto.TeacherDTO;
import com.crud.crudbasico.repository.IteacherRepository;
import com.crud.crudbasico.repository.entity.Teacher;
import com.crud.crudbasico.service.IProfesorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements IProfesorService {

    private  final IteacherRepository repository;

    public TeacherServiceImpl(IteacherRepository repository){
        this.repository = repository;
    }

    @Override
    public void save(TeacherDTO teacher) {
       if (!repository.existsById(teacher.getId())){
           repository.save(new Teacher(teacher));
       }

    }

    @Override
    public List<TeacherDTO> getAll() {
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

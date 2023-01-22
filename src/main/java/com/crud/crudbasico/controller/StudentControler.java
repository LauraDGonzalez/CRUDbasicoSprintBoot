package com.crud.crudbasico.controller;

import com.crud.crudbasico.dto.StudentDTO;
import com.crud.crudbasico.dto.TeacherDTO;
import com.crud.crudbasico.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentControler {
    public IStudentService iStudentService;

    public StudentControler(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @GetMapping() // Permite obtener los datos
    public ResponseEntity<?> getStudentAll(){ // ResponseEntity responde en formato json para la aplicacion web
        return ResponseEntity // contiene el status de la respuesta, si salio bien o mal
                .ok()  // Siempre va a responder ok
                .body(iStudentService.getAll()); // en el cuerpo si se encuentr en la bd persona se va a devolver la lista de personas encontradas
    }
    @PostMapping()// Permite insertar en la BD
    public ResponseEntity<?>
    saveStudent(@RequestBody StudentDTO student){ // @RequestBody  que está dentro del request
        iStudentService.save(student);// le enviamos la entidad
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping() // Permite  actualizar
    public ResponseEntity<?> // ? respuesta de cualquier tipo tengo entendido
    updateStudent(@RequestBody StudentDTO student){  // @RequestBody  que está dentro del request
        return new ResponseEntity<>( iStudentService.update(student), HttpStatus.CREATED); // HttpStatus.CREATED es el estatus que va a mostrar
    }

    @DeleteMapping // Permite eliminar
    public ResponseEntity<?>
    deleteStudent(@RequestBody StudentDTO studentDTO){
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(iStudentService.delete(studentDTO.getId()));
    }

}

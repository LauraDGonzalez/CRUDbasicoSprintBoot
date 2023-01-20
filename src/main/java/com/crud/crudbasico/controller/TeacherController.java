package com.crud.crudbasico.controller;

import com.crud.crudbasico.dto.TeacherDTO;
import com.crud.crudbasico.service.IProfesorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private IProfesorService iProfesorService;
    public TeacherController (IProfesorService iProfesorService){
        this.iProfesorService = iProfesorService;
    }

    @GetMapping()
    public ResponseEntity<?> getTeacherAll(){
        return ResponseEntity // contiene el status de la respuesta, si salio bien o mal
                .ok()  // Siempre va a responder ok
                .body(iProfesorService.getAll());
    }
    @PostMapping()
    public ResponseEntity<?>
    saveTeacher(@RequestBody TeacherDTO teacher){ // @RequestBody  que está dentro del request
        iProfesorService.save(teacher);// le enviamos la entidad
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping() // Para actualizar
    public ResponseEntity<?> // ? respuesta de cualquier tipo tengo entendido
    updateTeacher(@RequestBody TeacherDTO teacher){  // @RequestBody  que está dentro del request
        return new ResponseEntity<>( iProfesorService.update(teacher), HttpStatus.CREATED); // HttpStatus.CREATED es el estatus que va a mostrar
    }
}

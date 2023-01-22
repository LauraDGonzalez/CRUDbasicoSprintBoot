package com.crud.crudbasico.controller;

import com.crud.crudbasico.dto.TeacherDTO;
import com.crud.crudbasico.service.IProfesorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Simplifica la implentacion del controlador
@RequestMapping("/teacher") //  La URI de asignación de ruta, declaramos la URI para acceder al recurso, a traves de esta podemos acceder a los metodos de persona
public class TeacherController {

    // Siempre creamos las instancias de las interfaces no de las clases por temas de dependencias
    private final IProfesorService iProfesorService; // Se crea una implementacion de IPersonaRepository que es la interface para realizar el CRUD generico

    // Inyeccion de dependencias a traves del constructor
    public TeacherController (IProfesorService iProfesorService){
        this.iProfesorService = iProfesorService;
    }

    @GetMapping() // Permite obtener los datos
    public ResponseEntity<?> getTeacherAll(){ // ResponseEntity responde en formato json para la aplicacion web
        return ResponseEntity // contiene el status de la respuesta, si salio bien o mal
                .ok()  // Siempre va a responder ok
                .body(iProfesorService.getAll()); // en el cuerpo si se encuentr en la bd persona se va a devolver la lista de personas encontradas
    }
    @PostMapping()// Permite insertar en la BD
    public ResponseEntity<?>
    saveTeacher(@RequestBody TeacherDTO teacher){ // @RequestBody  que está dentro del request
        iProfesorService.save(teacher);// le enviamos la entidad
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping() // Permite  actualizar
    public ResponseEntity<?> // ? respuesta de cualquier tipo tengo entendido
    updateTeacher(@RequestBody TeacherDTO teacher){  // @RequestBody  que está dentro del request
        return new ResponseEntity<>( iProfesorService.update(teacher), HttpStatus.CREATED); // HttpStatus.CREATED es el estatus que va a mostrar
    }

    @DeleteMapping // Permite eliminar
    public ResponseEntity<?>
     deleteTeacher(@RequestBody TeacherDTO teacherDTO){ //TODO acá es teacher DTO o teacher?
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(iProfesorService.delete(teacherDTO.getId()));
    }
}

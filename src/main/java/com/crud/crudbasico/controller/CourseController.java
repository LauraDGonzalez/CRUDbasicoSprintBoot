package com.crud.crudbasico.controller;

import com.crud.crudbasico.dto.CourseDTO;
import com.crud.crudbasico.dto.TeacherDTO;
import com.crud.crudbasico.service.ICourseService;
import com.crud.crudbasico.service.IProfesorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Simplifica la implentacion del controlador
@RequestMapping("/course")
public class CourseController {
    private final ICourseService iCourseService;

    public CourseController(ICourseService iCourseService) {
        this.iCourseService = iCourseService;
    }
    @GetMapping() // Permite obtener los datos
    public ResponseEntity<?> getCourseAll(){ // ResponseEntity responde en formato json para la aplicacion web
        return ResponseEntity // contiene el status de la respuesta, si salio bien o mal
                .ok()  // Siempre va a responder ok
                .body(iCourseService.getAll()); // en el cuerpo si se encuentr en la bd persona se va a devolver la lista de personas encontradas
    }
    @PostMapping()// Permite insertar en la BD
    public ResponseEntity<?>
    saveCourse(@RequestBody CourseDTO course){ // @RequestBody  que está dentro del request
        iCourseService.save(course);// le enviamos la entidad
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping() // Permite  actualizar
    public ResponseEntity<?> // ? respuesta de cualquier tipo tengo entendido
    updateCourse(@RequestBody CourseDTO course){  // @RequestBody  que está dentro del request
        return new ResponseEntity<>( iCourseService.update(course), HttpStatus.CREATED); // HttpStatus.CREATED es el estatus que va a mostrar
    }

    @DeleteMapping // Permite eliminar
    public ResponseEntity<?>
    deleteCourse(@RequestBody CourseDTO courseDTO){ //TODO acá es teacher DTO o teacher?
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(iCourseService.delete(courseDTO.getId()));
    }
}

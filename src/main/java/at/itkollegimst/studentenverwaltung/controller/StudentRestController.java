package at.itkollegimst.studentenverwaltung.controller;


import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.exceptions.StudentValidierungFehlgeschlagen;
import at.itkollegimst.studentenverwaltung.services.StudentenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/studenten")
public class StudentRestController {

    private StudentenService studentenService;

    @GetMapping
    public ResponseEntity<List<Student>> gibAlleStudenten(){
        return ResponseEntity.ok(this.studentenService.alleStudenten());
    }

    @PostMapping
    public ResponseEntity<Student> StudentEinfuegen(@Valid @RequestBody Student student, BindingResult bindingResult) throws StudentValidierungFehlgeschlagen, Throwable {
        String errors = "";
        if(bindingResult.hasErrors()){
            for(ObjectError error : bindingResult.getAllErrors()){
                errors += "\nValidierungfeler für Objekt" + error.getObjectName() +
                        "im Feld" + ((FieldError)error).getField() + "mit folgendem Problem: " +
                        error.getDefaultMessage();
            }
            throw new Throwable(errors);
        }else {
            return ResponseEntity.ok(this.studentenService.studentEinfuegen(student));
        }
    }

    @DeleteMapping("/{id}")
    public String studentLoeschen(@PathVariable Long id){
        this.studentenService.studentLoeschenMitId(id);
        return "Student gelöscht";
    }

    @GetMapping("/mitplz/{plz}")
    public ResponseEntity<List<Student>> alleStudentenMitPlz(@PathVariable String plz){
        return ResponseEntity.ok(this.studentenService.alleStudentenMitPlz(plz));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> studentMitId(@PathVariable Long id){
        return ResponseEntity.ok(this.studentenService.alleStudentenMitId(id));
    }

}

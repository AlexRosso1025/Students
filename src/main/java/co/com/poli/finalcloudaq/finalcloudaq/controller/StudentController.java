package co.com.poli.finalcloudaq.finalcloudaq.controller;

import co.com.poli.finalcloudaq.finalcloudaq.model.Student;
import co.com.poli.finalcloudaq.finalcloudaq.services.IStudentService;
import co.com.poli.finalcloudaq.finalcloudaq.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StudentController {
    @Autowired
    IStudentService studentService;

    @PostMapping("/add")
    public Response addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("/delete/{cedula}")
    public Response deleteStudent(@PathVariable(value="cedula") String cedula){
        return studentService.deleteStudent(cedula);
    }

    @GetMapping("/winners")
    public Response winners(){
        return studentService.winners();
    }

    @GetMapping("/losers")
    public Response losers(){
        return studentService.losers();
    }

    @PutMapping("/modify/{cedula}")
    public Response modifySegStudent(@PathVariable(value="cedula") String cedula,@RequestBody Student student){
        return  studentService.modifySegStudent(cedula,student.getNotaSeguimiento());
    }

    @GetMapping("/list")
    public ArrayList<Student> getAllStudents(){
        return studentService.getAllStudent();
    }
}

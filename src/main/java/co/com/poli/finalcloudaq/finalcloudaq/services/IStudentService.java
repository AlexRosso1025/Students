package co.com.poli.finalcloudaq.finalcloudaq.services;

import co.com.poli.finalcloudaq.finalcloudaq.model.Student;
import co.com.poli.finalcloudaq.finalcloudaq.util.Response;

import java.util.ArrayList;

public interface IStudentService {
    Response addStudent(Student student);
    Response deleteStudent(String cedula);
    Response winners();
    Response losers();
    Response modifySegStudent(String cedula, double notaSeguimiento);
    ArrayList<Student> getAllStudent();
}

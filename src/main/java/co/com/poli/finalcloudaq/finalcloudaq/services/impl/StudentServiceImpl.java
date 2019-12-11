package co.com.poli.finalcloudaq.finalcloudaq.services.impl;

import co.com.poli.finalcloudaq.finalcloudaq.dao.IStudentDao;
import co.com.poli.finalcloudaq.finalcloudaq.model.Student;
import co.com.poli.finalcloudaq.finalcloudaq.services.IStudentService;
import co.com.poli.finalcloudaq.finalcloudaq.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.type.ArrayType;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao studentDao;


    @Override
    @Transactional
    public Response addStudent(Student student) {
        Response response = new Response();
        if(studentDao.existsById(student.getCedula())){
            response.setMessageBody("Estudiante Ya existe");
        }else{
            if(student.getNotaParcial()<0 || student.getNotaParcial()>5 || student.getNotaFinal()<0
            || student.getNotaFinal()>5 || student.getNotaSeguimiento()<0 || student.getNotaSeguimiento()>5){
                response.setMessageBody("Las Notas deben ser mayor a 0 y menor que 5");
                response.setMessage("Not Found");
                response.setState(false);
                response.setCodeMessage(404);
            }else{
                student.setNotaDefinitiva((student.getNotaFinal()*0.25+student.getNotaParcial()*0.25
                +student.getNotaSeguimiento()*0.5));
                studentDao.save(student);
                response.setState(true);
                response.setMessage("Ok");
                response.setCodeMessage(201);
                response.setMessageBody(student);
            }
        }
        return response;
    }

    @Override
    @Transactional
    public Response deleteStudent(String cedula) {
        Response response = new Response();
        if(studentDao.existsById(cedula)){
            studentDao.deleteById(cedula);
            response.setMessage("No Content");
            response.setState(true);
            response.setCodeMessage(204);
            response.setMessageBody("Estudiante Eliminado");
        }else{
            response.setCodeMessage(404);
            response.setState(false);
            response.setMessage("No existe el estudiante que desea eliminar");
            response.setMessageBody(getAllStudent());
        }
        return response;
    }

    @Override
    @Transactional
    public Response winners() {
        Response response = new Response();
        int winners=0;
        for (Student student: studentDao.findAll()){
            if(student.getNotaDefinitiva()>=3){
                winners++;
            }
        }
        response.setState(true);
        response.setMessage("Ok");
        response.setCodeMessage(201);
        response.setMessageBody(winners + " Personas aprobaron");
        return response;
    }

    @Override
    @Transactional
    public Response losers() {
        Response response = new Response();
        int losers=0;
        for (Student student: studentDao.findAll()){
            if(student.getNotaDefinitiva()<3){
                losers++;
            }
        }
        response.setState(true);
        response.setMessage("Ok");
        response.setCodeMessage(201);
        if(losers==1){
            response.setMessageBody(losers + "Persona reprobó");
        }else{
            response.setMessageBody(losers + " Personas reprobaron");
        }
        return response;
    }

    @Override
    @Transactional
    public Response modifySegStudent(String cedula, double notaSeguimiento) {
        Response response = new Response();
        for(Student student : studentDao.findAll()){
            if(studentDao.existsById(cedula)){
                student.setNotaSeguimiento(notaSeguimiento);
                student.setNotaDefinitiva((student.getNotaFinal()*0.25+student.getNotaParcial()*0.25
                        +student.getNotaSeguimiento()*0.5));
                response.setMessageBody(getAllStudent());
                response.setMessage("Ok");
                response.setState(true);
                response.setCodeMessage(201);
            }else{
                response.setMessage("Not Found");
                response.setState(false);
                response.setCodeMessage(404);
                response.setMessageBody("No existe el estudiante que intenta actualizar");
            }
        }
        return response;
    }

    @Override
    @Transactional
    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> studentList  = new ArrayList<>();
        for (Student student: studentDao.findAll()){
            studentList.add(student);
        }
        return studentList;
    }
}

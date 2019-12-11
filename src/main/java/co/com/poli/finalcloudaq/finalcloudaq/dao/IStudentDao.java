package co.com.poli.finalcloudaq.finalcloudaq.dao;

import co.com.poli.finalcloudaq.finalcloudaq.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentDao extends CrudRepository<Student,String> {
}

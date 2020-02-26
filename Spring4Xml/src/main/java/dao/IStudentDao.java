package dao;

import domain.Student;

import java.util.List;

public interface IStudentDao {

    List<Student> findAll();

}

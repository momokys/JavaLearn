package dao;

import domain.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IStudentDao {


    void add(Student stu);

    List<Student> findAll();

    List<Student> findByMajorId(Integer majorId);

}

package dao.Impl;

import dao.IStudentDao;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import javax.annotation.Resource;
import java.util.List;

@Repository
@Scope("singleton")
public class IStudentDaoImpl implements IStudentDao {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Student> findAll() {
        String sql = "select * from tab_stu";
        List<Student> list = null;
        try {
            list = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }


}

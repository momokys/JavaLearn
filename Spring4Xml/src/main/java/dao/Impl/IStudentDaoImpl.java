package dao.Impl;

import dao.IStudentDao;
import domain.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

public class IStudentDaoImpl implements IStudentDao {

    JdbcTemplate template;

    public IStudentDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

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

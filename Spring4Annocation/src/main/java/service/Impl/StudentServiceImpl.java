package service.Impl;


import dao.IStudentDao;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import service.StudentService;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * Scope
 *      该注解用于指定bean的作用范围 singleton(单例)、prototype(多例)
 */

@Service("studentService")
@Scope("singleton")
public class StudentServiceImpl implements StudentService {

    /**
     * Autowired:
     *      自动注入，该注解会根据数据类型在IOC容器中寻找相同类型的Bean或者子类型（子类、实现类)
     *
     * Qualifier("dao"):
     *      在注入类成员时需要与Autowired一起使用。注入方法参数时可以单独使用
     *
     * Resource(name = "IStudentDao")
     *      该注解直接指定bean的id(name)
     */


    @Autowired
    IStudentDao studentDao;

    public List<Student> findAll(){
        return studentDao.findAll();
    }
}

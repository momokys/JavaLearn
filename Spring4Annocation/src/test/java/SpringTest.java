import config.SpringConfig;
import domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.StudentService;

import java.util.List;


/**
 * spring集成junit：
 *      1、导入spring整合junit的jar包
 *      2、使用spring注解替换junit的main方法为spring提供的
 *          @RunWith：
 *             属性：
 *                  vlaue：SpringJUnit4ClassRunner.class
 *
 *      3、使用注解告知spring的运行器：spring和IOC容器是基于配置类还是xml创建的
 *          @ContextConfiguration：
 *              属性：
 *                  location：指定XML文件的位置
 *                  class：指定配置类字节码
 *
 * 当我们使用spring 5.x版本时，要求junit的jar必须是4.12及以上
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SpringTest {

    @Autowired
    private StudentService service;

    @Test
    public void finAllStudentTest(){

        List<Student> all = service.findAll();

        for (Student stu : all){
            System.out.println(stu);
        }
    }

}

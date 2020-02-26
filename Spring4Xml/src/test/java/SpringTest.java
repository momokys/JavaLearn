import domain.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StudentService;

import java.util.List;

public class SpringTest {

    @Test
    public void finAllStudentTest(){

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        StudentService service = context.getBean("studentService", StudentService.class);
        List<Student> all = service.findAll();

        for (Student stu : all){
            System.out.println(stu);
        }
    }

}

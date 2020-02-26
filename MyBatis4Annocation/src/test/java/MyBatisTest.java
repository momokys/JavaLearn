import dao.ICourseDao;
import dao.IMajorDao;
import dao.IStudentDao;
import domain.Major;
import domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    InputStream in;
    SqlSessionFactory factory;
    SqlSession session;
    IStudentDao stuDao;
    ICourseDao couDao;
    IMajorDao majDao;

    @Before
    public void init() throws IOException {

        in =Resources.getResourceAsStream("SqlMapConfig.xml");

        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        stuDao = session.getMapper(IStudentDao.class);
        couDao = session.getMapper(ICourseDao.class);
        majDao = session.getMapper(IMajorDao.class);
    }

    @After
    public void destroy() throws IOException {

        session.commit();
        session.close();
        in.close();

    }

    @Test
    public  void addMajor(){

        Major major = new Major();
        major.setName("物联网");
        majDao.add(major);
        System.out.println(major);

    }

    @Test
    public void findByNameMajorTest(){

        Major major = majDao.findByName("嵌入式系统");

        System.out.println("-----------------------------------------");
        System.out.println(major);

        for (Student stu:major.getStus()){
            System.out.println(stu);
        }
        System.out.println("-----------------------------------------");

    }

    @Test
    public void findAllStuTest(){

        List<Student> all = stuDao.findAll();
        for (Student stu:all){
            System.out.println(stu);
        }

    }

    @Test
    public void addStuTest(){

        Student stu = new Student();
        stu.setName("非白");
        stu.setSex("男");
        stu.setMajor_id(majDao.findByName("嵌入式系统").getId());

        stuDao.add(stu);
        System.out.println(stu);

    }

}

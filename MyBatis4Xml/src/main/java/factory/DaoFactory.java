package factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DaoFactory {

    private static InputStream in;
    private static SqlSessionFactory factory;
    private static SqlSession session;

    static{
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession(true);
    }
    public static Object getDao(Class clazz){

        return session.getMapper(clazz);
    }
}

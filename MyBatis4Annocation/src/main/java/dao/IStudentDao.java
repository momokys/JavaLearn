package dao;

import domain.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IStudentDao {

    @Insert("insert into tab_stu(name,sex,major_id) values(#{name},#{sex},#{major_id})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void add(Student stu);

    @Select("select * from tab_stu")
    @Results(id="stuMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "major_id",property = "major_id"),
            @Result(column = "major_id",property = "major",
                    one = @One(select = "dao.IMajorDao.findById",fetchType = FetchType.EAGER)),
    })
    List<Student> findAll();

    @Select("select * from tab_stu where major_id=#{majorId}")
    List<Student> findByMajorId(Integer majorId);

}

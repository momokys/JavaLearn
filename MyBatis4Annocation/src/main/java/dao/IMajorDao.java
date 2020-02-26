package dao;

import domain.Major;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IMajorDao {

    @Select("select * from tab_major")
    @Results(id="majorMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "id",property = "stus",
                    many = @Many(select = "dao.IStudentDao.findByMajorId",fetchType = FetchType.LAZY))
    })
    List<Major> findAll();

    @Select("select * from tab_major where name=#{name}")
    @ResultMap("majorMap")
    Major findByName(String name);

    @Select("select * from tab_major where id=#{id}")
    @ResultMap(value = {"majorMap"})
    Major findById(Integer id);

    @Insert("insert into tab_major(name) values(#{name})")
    @Options(useGeneratedKeys = true,keyProperty = "id", keyColumn = "id")
    void add(Major major);

}

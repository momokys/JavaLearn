package dao;

import domain.Major;
import java.util.List;

public interface IMajorDao {


    List<Major> findAll();


    Major findByName(String name);

    Major findById(Integer id);

    void add(Major major);

}

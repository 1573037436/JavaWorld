package com.zzj.javaEE.mybatis;
import java.util.List;
import com.zzj.javaSE.model.Student;
 
public interface StudentMapper {
 
    /**
     *
     * @return
     */
    List<Student> selectAll();
}
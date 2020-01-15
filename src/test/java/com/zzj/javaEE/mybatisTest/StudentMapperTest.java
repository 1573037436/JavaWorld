package com.zzj.javaEE.mybatisTest;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.zzj.javaSE.model.Student;
import com.zzj.javaSE.object.clone.RandomStringUtil;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
/**
 * 基础crud功能
 * @author zzj
 * @date 2020年1月15日
 */
public class StudentMapperTest {
    private static SqlSessionFactory sqlSessionFactory;
 
    @BeforeClass
    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    @Test
    public void testSelectList() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            List<Student> students = sqlSession.selectList("selectAll");
            for (int i = 0; i < students.size(); i++) {
                System.out.println("selectAll result "+students.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    
    @Test
    public void addStudent() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            int studentNum=new Random().nextInt();
            String sex=null;
            Random random=new Random(System.currentTimeMillis());
			if(random.nextBoolean()){
				sex="女";
			}else {
				sex="男";
			}
            Student student=new Student(RandomStringUtil.getChineseName(), sex, studentNum, "武汉大学"+studentNum);
            int num = sqlSession.insert("addStudent", student);
            sqlSession.commit();
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void findById() {
        SqlSession sqlSession = null;
        Student student=null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            student = sqlSession.selectOne("findById", 1);
            System.out.println("findById result "+student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    
    @Test
    public void updateStudent() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            Student student=sqlSession.selectOne("findById", 56);
            if (student!=null) {
                student.setClassName("updateStudent ClassName");
                int updateNum = sqlSession.update("updateStudent", student);
                sqlSession.commit();
			}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    @Test
    public void deleteStudent() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            int updateNum = sqlSession.delete("deleteStudent", 1);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
    
    @Test
    public void findStudentWithNameLike(){
    	SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            Student student=sqlSession.selectOne("findById", 5);
            if(student!=null){
            	  student.setName(null);
                  List<Student> students= sqlSession.selectList("findStudentWithNameLike", student);
                  sqlSession.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
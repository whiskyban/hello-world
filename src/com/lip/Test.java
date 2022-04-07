package com.lip;

import com.lip.Utils.MybatisUtils;
import com.lip.dao.StudentMapper;
import com.lip.dao.UserMapper;
import com.lip.pojo.Student;
import com.lip.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.jcp.xml.dsig.internal.dom.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    @org.junit.Test
    public void selectUser() {
        SqlSession session = MybatisUtils.getSession();
        //方法一：
        // List<User> users=session.selectList("com.lip.dao.UserMapper.selectUser");
        //方法二：
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }

    @org.junit.Test
    public void testSelectUserById() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
        session.close();
    }

    @org.junit.Test
    public void testSelectByNP() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserByNP("李平", "123456");
        System.out.println(user);
        session.close();
    }

    @org.junit.Test
    public void testSelectByNP1() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "李平");
        map.put("pwd", "123456");
        User user = mapper.selectUserByNP1(map);
        System.out.println(user);
        session.close();
    }

    @org.junit.Test
    public void testAddUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(6, "王奕", "wangwang");
        int i = mapper.addUser(user);
        session.close();
    }

    @org.junit.Test
    public void testUpdateUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(1, "李平", "156789");
        mapper.upDateUser(user);
        session.close();
    }

    @org.junit.Test
    public void testDeleteUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteUser(6);
        session.close();
    }

    @org.junit.Test
    public void testGetAllUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.getAllUser();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }

    ////////////////////////Teacher/////////////////


    @org.junit.Test
    public void testGetStudents2() {
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudents2();

        for (Student student : students) {
            System.out.println(
                    "学生名:" + student.getName()
                            + "\t老师:" + student.getTeacher().getName());

        }
    }
}
package com.kaorou.mybatis.mapper;

import com.kaorou.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestDemo1 {
    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void before() throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void test01() throws IOException {

        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectUserById(29);
        System.out.println(user);
        session.close();

    }

    @Test
    public void test02() throws IOException {

        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> list = userMapper.selectUserByName("小");
        for (User user : list) {
            System.out.println(user);
        }
        session.close();

    }

    @Test
    public void test03() throws IOException {

        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("wanbo");
        user.setSex("2");
        user.setBirthday(new Date());
        user.setAddress("1006A");
        userMapper.insertUser(user);
        session.commit();
        session.close();

    }

    @Test
    public void test04() {

        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setId(10);
        user.setUsername("shuangye");
        user.setSex("2");
        user.setBirthday(new Date());
        user.setAddress("深思创芯");
        userMapper.updateUserById(user);
        session.commit();
        session.close();

    }

    @Test
    public void test05() {

        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        userMapper.deleteUserById(25);
        session.commit();
        session.close();

    }
}

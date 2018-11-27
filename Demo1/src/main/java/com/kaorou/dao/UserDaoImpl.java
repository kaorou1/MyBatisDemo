package com.kaorou.dao;

import com.kaorou.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements UserDao {

    //注入
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void selectUserById(Integer id) {
        SqlSession session = sqlSessionFactory.openSession();
        User user = session.selectOne("findUserById", id);
        System.out.println(user);
        session.close();
    }
}

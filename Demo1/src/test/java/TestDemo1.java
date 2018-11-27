import com.kaorou.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestDemo1 {

    @Test
    public void testDemo1() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //打开与数据库的会话
        SqlSession session = sqlSessionFactory.openSession();

        User user = session.selectOne("findUserById", 1);
        System.out.println(user);
        session.close();
    }

    @Test
    public void testDemo2() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //打开与数据库的会话
        SqlSession session = sqlSessionFactory.openSession();

        List<User> list = session.selectList("findUserLike", "%王%");
        for (User user : list) {
            System.out.println(user);
        }

        session.close();
    }

    @Test
    public void testDemo3() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //打开与数据库的会话
        SqlSession session = sqlSessionFactory.openSession();

        List<User> list = session.selectList("findUserLike2", "王");
        for (User user : list) {
            System.out.println(user);
        }

        session.close();
    }

    @Test
    public void testDemo4() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //打开与数据库的会话
        SqlSession session = sqlSessionFactory.openSession();

        List<User> list = session.selectList("findUserLike3", "王");
        for (User user : list) {
            System.out.println(user);
        }

        session.close();
    }

    @Test
    public void testDemo5() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //打开与数据库的会话
        SqlSession session = sqlSessionFactory.openSession();

        List<User> list = session.selectList("findUserLike4", "王");
        for (User user : list) {
            System.out.println(user);
        }

        session.close();
    }

    @Test
    public void testDemo6() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //打开与数据库的会话
        SqlSession session = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("kaorou");
        user.setAddress("电子科大沙河");
        user.setSex("1");
        user.setBirthday(new Date());

        int i = session.insert("insertUser", user);
        //提交事务
        session.commit();
        session.close();
    }

    @Test
    public void testDemo7() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //打开与数据库的会话
        SqlSession session = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("kaorou");
        user.setAddress("电子科大沙河");
        user.setSex("1");
        user.setBirthday(new Date());

        int i = session.insert("insertUser2", user);
        System.out.println(user.getId());
        //提交事务
        session.commit();
        session.close();


    }

    @Test
    public void testDemo8() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //打开与数据库的会话
        SqlSession session = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(28);
        user.setUsername("xinye");
        user.setAddress("电子科大沙河");
        user.setSex("2");
        user.setBirthday(new Date());

        int i = session.insert("updateUserById", user);
        //提交事务
        session.commit();
        session.close();
    }

    @Test
    public void testDemo9() throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //打开与数据库的会话
        SqlSession session = sqlSessionFactory.openSession();

        session.delete("deleteUserById", 26);
        //提交事务
        session.commit();
        session.close();
    }
}


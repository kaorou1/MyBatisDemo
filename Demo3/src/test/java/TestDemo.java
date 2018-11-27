import com.kaorou.mybatis.entity.Order;
import com.kaorou.mybatis.entity.QueryVo;
import com.kaorou.mybatis.entity.User;
import com.kaorou.mybatis.mapper.OrderMapper;
import com.kaorou.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestDemo {

    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void before() throws IOException {
        InputStream is = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void test01() {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("小");
        vo.setUser(user);

        List<User> list = userMapper.selectUserByQueryVo(vo);
        for (User user1 : list) {
            System.out.println(user1);

        }
        session.commit();
    }

    @Test
    public void test02() {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        Integer integer = userMapper.countAll();
        System.out.println(integer);
        session.commit();
    }

    @Test
    public void test03() {
        SqlSession session = sqlSessionFactory.openSession();
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        List<Order> list = orderMapper.selectAllOrder();
        for (Order order : list) {
            System.out.println(order);
        }
        session.commit();
    }

    @Test
    public void test04() {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();
//        user.setSex("1");
        user.setUsername("wanbo");

        List<User> list = userMapper.selectUserBySexAndUsername(user);
        for (User u : list) {
            System.out.println(u);
        }

    }

    @Test
    public void test05() {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<>();
        list.add(24);
        list.add(30);
        list.add(32);
        vo.setIdList(list);

        List<User> userList = userMapper.selectUserByIds(vo);
        for (User user : userList) {
            System.out.println(user);
        }

    }

    @Test
    public void test06() {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        QueryVo vo = new QueryVo();
        Integer[] ids = {1, 24, 30};
        vo.setIds(ids);

        List<User> userList = userMapper.selectUserByIds(vo);
        for (User user : userList) {
            System.out.println(user);
        }

    }

    @Test
    public void test07() {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        Integer[] ids = {1, 24, 30};


        List<User> userList = userMapper.selectUserByIdArray(ids);
        for (User user : userList) {
            System.out.println(user);
        }

    }

    @Test
    public void test08() {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(32);
        list.add(30);


        List<User> userList = userMapper.selectUserByIdList(list);
        for (User user : userList) {
            System.out.println(user);
        }

    }
}

import com.kaorou.dao.UserDao;
import com.kaorou.dao.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestDemo2 {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void beforeTest() throws IOException {
        String resources = "sqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(resources);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    /**
     * 原始的DAO开发
     */
    public void testDao() {

        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        userDao.selectUserById(28);
    }
}

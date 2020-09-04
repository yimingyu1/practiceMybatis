package cn.mingyu;


import cn.mingyu.Dao.IUserDao;
import cn.mingyu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException, IOException {
        //读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlsessionfactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //使用工厂生产sqlsession对象
        SqlSession sqlSession = factory.openSession();
        //使用sqlsession创建dao接口的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user: users
             ) {
            System.out.println(user);
        }
        //释放资源
        sqlSession.close();
        in.close();


    }
}

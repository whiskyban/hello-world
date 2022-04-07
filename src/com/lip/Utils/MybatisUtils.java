package com.lip.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static{
        try{
            String resourse="mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resourse);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSession(){
        return getSession(true);
    }
    public static SqlSession getSession(boolean flag){
        return sqlSessionFactory.openSession(flag);
    }
}

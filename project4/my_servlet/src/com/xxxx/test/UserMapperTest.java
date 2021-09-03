package com.xxxx.test;

import com.xxxx.entity.User;
import com.xxxx.mapper.UserMapper;
import com.xxxx.until.GetSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserMapperTest {

    @Test
    public void addUser() {
        SqlSession sqlSession = GetSqlSession.createSqlSession();
        UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
        userMapper.saveUser(new User("admin","admin","2541516839@qq.com"));
        sqlSession.commit();
    }
}
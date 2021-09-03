package com.xxxx.test;

import com.xxxx.entity.User;
import com.xxxx.mapper.UserMapper;
import com.xxxx.until.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

public class Test {
    public static void main(String[] args) {
        SqlSession sqlSession = GetSqlSession.createSqlSession();
        UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
        User user=userMapper.queryUserByName("admin");
        System.out.println(user);
    }

}

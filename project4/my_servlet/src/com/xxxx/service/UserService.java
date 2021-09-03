package com.xxxx.service;

import com.xxxx.entity.User;
import com.xxxx.entity.vo.MessageModel;
import com.xxxx.mapper.UserMapper;
import com.xxxx.until.GetSqlSession;
import com.xxxx.until.StringUtil;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    public MessageModel userLogin(String uname, String upwd) {
        MessageModel messageModel =new MessageModel();

        User u =new User();
        u.setUserName(uname);
        u.setUserPwd(upwd);
        messageModel.setObject(u);

        if(StringUtil.isEmpty(uname)||StringUtil.isEmpty(upwd)){
            messageModel.setCode(0);
            messageModel.setMsg("用户名和密码不许为空");
            return messageModel;
        }
        SqlSession sqlSession = GetSqlSession.createSqlSession();
        UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
        User user   =userMapper.queryUserByName(uname);

        if(user == null){
            messageModel.setCode(0);
            messageModel.setMsg("用户名不存在");
            return messageModel;
        }
        //user.getUserPwd()!=upwd !upwd.equals(user.getUserPwd())
        if(!upwd.equals(user.getUserPwd())){
            messageModel.setCode(0);
            messageModel.setMsg("密码错误");
            return messageModel;
        }

        messageModel.setObject(user);
        sqlSession.close();
        return messageModel;
    }

    public MessageModel userRegisterin(String uname,String upwd,String uemail) {
        MessageModel messageModel =new MessageModel();

        User u =new User();
        u.setUserName(uname);
        u.setUserPwd(upwd);
        u.setEmail(uemail);
        messageModel.setObject(u);

        if(StringUtil.isEmpty(uname)||StringUtil.isEmpty(upwd)||StringUtil.isEmpty(uemail)){
            messageModel.setCode(0);
            messageModel.setMsg("不许为空");
            return messageModel;
        }

        SqlSession sqlSession = GetSqlSession.createSqlSession();
        UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
        userMapper.saveUser(u);
        sqlSession.commit();
        sqlSession.close();
        return messageModel;
    }
}

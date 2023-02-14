package com.sues.service.impl;

import com.sues.dao.RecordMapper;
import com.sues.dao.UserMapper;
import com.sues.pojo.User;
import com.sues.service.UserService;
import com.sues.utils.MybatisUtil;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {
    @Override
    public boolean auth(String username, String password, HttpSession session) {
        try (SqlSession sqlSession = MybatisUtil.getSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUser(username, password);
            if(user == null) return false;
            session.setAttribute("user", user);
            return true;
        }
    }

    @Override
    public void updateName(String name, String id) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.updateName(name,id);
        }
    }

    @Override
    public void updatePassword(String password, String id) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.updatePassword(password,id);
        }
    }

    @Override
    public String getOriginPassword(String id) {
        try (SqlSession sqlSession = MybatisUtil.getSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            return mapper.getOriginPassword(id);
        }
    }
}

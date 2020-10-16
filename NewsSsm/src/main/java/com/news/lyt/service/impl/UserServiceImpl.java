package com.news.lyt.service.impl;

import com.news.lyt.dao.UserMapper;
import com.news.lyt.domain.EmailActive;
import com.news.lyt.domain.User;
import com.news.lyt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 注册
     */
    @Override
    public void register(User user) {
        userMapper.register(user);
    }

    @Override
    public void active(EmailActive emailActive) {
        userMapper.active(emailActive);
    }

     public User login(User user) {
        // 生成密文
        String pwd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(pwd);
        User user1=userMapper.login(user);
        return user1;
    }

    @Override
    public User findUser(String username) {
        return userMapper.findUser(username);
    }


}

package com.news.lyt.service;

import com.news.lyt.domain.EmailActive;
import com.news.lyt.domain.User;

public interface IUserService {
    public void register(User user);

    void active(EmailActive emailActive);

    User login(User user);
    //判断数据库中用户是否存在
    User findUser(String username);


}

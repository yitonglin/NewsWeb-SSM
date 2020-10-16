package com.news.lyt.dao;


import com.news.lyt.domain.EmailActive;
import com.news.lyt.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    public void register(User user);

    void active(EmailActive emailActive);

    User login(User user);

    User findUser(@Param("username") String username);

}
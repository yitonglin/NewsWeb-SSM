package com.news.lyt.service.impl;

import com.news.lyt.dao.MySelfMapper;
import com.news.lyt.domain.*;
import com.news.lyt.service.MySelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MySelfServiceImpl implements MySelfService {

    @Autowired
    private MySelfMapper myselfMapper;
    @Override
    public String findhead(User user) {
        return myselfMapper.findhead(user);
    }

    @Override
    public User lookMyself(String username) {
        return myselfMapper.lookMyself(username);
    }

    @Override
    public void reMyself(User user) {
        myselfMapper.reMyself(user);
    }

    @Override
    public int myComments(int id) {
        return myselfMapper.myComments(id);
    }

    @Override
    public List<MyCommentsVo> lookMyselfComments(int page, int uid) {
        return myselfMapper.lookMyselfComments(page,uid);
    }

    @Override
    public UserIdAndPhoto findUserIdAndPhoto(String username) {
        return myselfMapper.findUserIdAndPhoto(username);
    }

    @Override
    public News findNewsByNid(int nid) {
        return myselfMapper.findNewsByNid(nid);
    }

    @Override
    public int lookMyselfCollectionNum(int id) {
        return myselfMapper.lookMyselfCollectionNum(id);
    }

    @Override
    public List<CollectionVo> lookMyselfCollection(int userId, int page) {
        return myselfMapper.lookMyselfCollection(userId,page);
    }
}

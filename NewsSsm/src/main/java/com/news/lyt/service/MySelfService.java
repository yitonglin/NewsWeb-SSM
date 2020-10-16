package com.news.lyt.service;

import com.news.lyt.domain.*;

import java.util.List;

public interface MySelfService {
    String findhead(User user);

    User lookMyself(String username);

    void reMyself(User user);

    int myComments(int id);

    List<MyCommentsVo> lookMyselfComments(int page,int uid);

    UserIdAndPhoto findUserIdAndPhoto(String username);

    News findNewsByNid(int nid);
    //查询收藏数量
    int lookMyselfCollectionNum(int id);

    //查询用户收藏的博客
    List<CollectionVo> lookMyselfCollection(int userId, int page);
}

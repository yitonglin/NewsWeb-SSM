package com.news.lyt.dao;

import com.news.lyt.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MySelfMapper {
    String findhead(User user);

    User lookMyself(String username);

    void reMyself(User user);

    int myComments(int id);

    List<MyCommentsVo> lookMyselfComments(int page,int uid);

    UserIdAndPhoto findUserIdAndPhoto(String username);

    News findNewsByNid(int nid);

    int lookMyselfCollectionNum(@Param("id") int id);

    //查询收藏博客信息
    List<CollectionVo> lookMyselfCollection(@Param("userId")int userId,@Param("page")int page);
}

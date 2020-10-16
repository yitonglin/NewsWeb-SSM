package com.news.lyt.dao;


import java.util.List;

import com.news.lyt.domain.*;
import org.apache.ibatis.annotations.Param;

public interface NewsMapper {

    List<News> newsPage();

    List<TakePhtoco> takePhotos(int categoryPhoto);

    List<News> searchnews(String title);

    List<News> hotNews();

    News details(String title);

    News commens(String title);

    List<Comments> nidByid(NidById nidById);

    int idByNum(int nid);

    UsernameAndPhoto uidByUsername(Integer uid);

   Integer findnid(String title);

    Integer finduid(String username);

    void insertcomments(CommentsVoSave commentsVo);

    //处理分类页面中热门资讯的数据查询操作
    List<News> categoryHotNews(int active);

    //根据页面分类功能，查询博客新闻
    List<News> categoryPage(int active);

    //根据博客标题查询博客id
    int searchNewsId(String title);

    //设置收藏功能
    void insertCollection(@Param("userId") int userId,@Param("newsId") int newsId);

    //取消收藏的功能
    void deleteCollection(@Param("userId") int userId,@Param("newsId") int newsId);

    int collectionop(@Param("userId") int userId,@Param("newsId") int newsId);

    String findhead(User user);
    //设置文章阅读量
    void addLookNum(String title);
    void addOneReply(Integer nid);

}
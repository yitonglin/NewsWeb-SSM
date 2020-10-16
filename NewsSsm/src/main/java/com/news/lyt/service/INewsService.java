package com.news.lyt.service;

import com.news.lyt.domain.*;

import java.util.List;

public interface INewsService {

    int collectionop(int userId,int newsId);

    List<News> newsPage();

    List<TakePhtoco> takePhotos(int categoryPhoto);

    List<News> searchnews(String title);
    List<News> hotNews();

    News details(String title);

    News commens(String title);

    List<Comments> nidByid(NidById nidById);

    CommentsVo uidByUser(Integer uid);

    int idByNum(int nid);

    UsernameAndPhoto uidByUsername(Integer uid);

    Integer findnid(String title);

    Integer finduid(String username);

    void insertcomments(CommentsVoSave commentsVo);

    //处理分类页面热门资讯
    List<News> categoryHotNews(int active);

    //查询博客id
    int searchNewsId(String title);

    //设置收藏
    void insertCollection(int userId,int newsId);

    //取消收藏
    void deleteCollection(int userId,int newsId);
    //分类页面数据处理
    List<News> categoryPage(int active);

    String findhead(User user);
    //处理文章点击量
    void addLookNum(String title);
    void addOneReply(Integer nid);

}

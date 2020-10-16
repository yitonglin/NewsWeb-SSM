package com.news.lyt.service.impl;

import com.news.lyt.dao.NewsMapper;
import com.news.lyt.domain.*;
import com.news.lyt.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    private NewsMapper newsMapper;

    //查询博文是否被收藏
    @Override
    public int collectionop(int userId, int newsId) {
        return newsMapper.collectionop(userId,newsId);
    }

    @Override
    public List<News> newsPage() {
        return newsMapper.newsPage();
    }

    @Override
    public List<TakePhtoco> takePhotos(int categoryPhoto) {
        return newsMapper.takePhotos(categoryPhoto);
    }

    @Override
    public List<News> searchnews(String title) {
        return newsMapper.searchnews(title);
    }

    @Override
    public List<News> hotNews() {
        return newsMapper.hotNews();
    }

    @Override
    public News details(String title) {
        return newsMapper.details(title);
    }

    @Override
    public News commens(String title) {
        return newsMapper.commens(title);
    }

    @Override
    public List<Comments> nidByid(NidById nidById) {
        return newsMapper.nidByid(nidById);
    }

    @Override
    public CommentsVo uidByUser(Integer uid) {
        return null;
    }

    @Override
    public int idByNum(int nid) {
        return newsMapper.idByNum(nid);
    }

    @Override
    public UsernameAndPhoto uidByUsername(Integer uid) {
        return newsMapper.uidByUsername(uid);
    }


     @Override
    public Integer findnid(String title) {
        return newsMapper.findnid(title);
    }

    @Override
    public Integer finduid(String username) {
        return newsMapper.finduid(username);
    }

    @Override
    public void insertcomments(CommentsVoSave commentsVo) {
        newsMapper.insertcomments(commentsVo);
    }

    @Override
    public List<News> categoryHotNews(int active){
        return  newsMapper.categoryHotNews(active);
    }

    @Override
    public int searchNewsId(String title) {
        return newsMapper.searchNewsId(title);
    }

    @Override
    public void insertCollection(int userId, int newsId) {
        newsMapper.insertCollection(userId,newsId);
    }

    @Override
    public void deleteCollection(int userId, int newsId) {
        newsMapper.deleteCollection(userId,newsId);
    }

    @Override
    public List<News> categoryPage(int active) {
        return newsMapper.categoryPage(active);
    }

    @Override
    public String findhead(User user) {
        return newsMapper.findhead(user);
    }
    @Override
    public void addLookNum(String title) {
        newsMapper.addLookNum(title);
    }
    @Override
    public void addOneReply(Integer nid) {
        newsMapper.addOneReply(nid);
    }


}

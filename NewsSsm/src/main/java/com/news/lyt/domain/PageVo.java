package com.news.lyt.domain;

import java.util.List;

public class PageVo {
    private int countNum;//总数据
    private List<NewsSerach> listNews;//查询出的新闻


    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }

    public List<NewsSerach> getListNews() {
        return listNews;
    }

    public void setListNews(List<NewsSerach> listNews) {
        this.listNews = listNews;
    }
}

package com.news.lyt.domain;

import java.sql.Time;

public class CollectionVo {
    //文章标题
    private String newsname;
    //文章类型
    private String cname;

    //评论总数
    private String replynum;

    //文章时间
    private String time;

    @Override
    public String toString() {
        return "CollectionVo{" +
                "newsname='" + newsname + '\'' +
                ", cname='" + cname + '\'' +
                ", replynum='" + replynum + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getNewsname() {
        return newsname;
    }

    public void setNewsname(String newsname) {
        this.newsname = newsname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getReplynum() {
        return replynum;
    }

    public void setReplynum(String replynum) {
        this.replynum = replynum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

package com.news.lyt.domain;

public class MyCommentsVo {
    private String title;//文章标题
    private String category;//文章分类
    private int nid;//文章id
    private int replynum;//回复数量
    private String photo;//头像
    private String ntime;//文章时间
    private String username;
    private String content;//评论内容
    private String commentstime;//评论时间

    @Override
    public String toString() {
        return "MyCommentsVo{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", nid=" + nid +
                ", replynum=" + replynum +
                ", photo='" + photo + '\'' +
                ", ntime='" + ntime + '\'' +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                ", commentstime='" + commentstime + '\'' +
                '}';
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentstime() {
        return commentstime;
    }

    public void setCommentstime(String commentstime) {
        this.commentstime = commentstime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public int getReplynum() {
        return replynum;
    }

    public void setReplynum(int replynum) {
        this.replynum = replynum;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNtime() {
        return ntime;
    }

    public void setNtime(String ntime) {
        this.ntime = ntime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }




}

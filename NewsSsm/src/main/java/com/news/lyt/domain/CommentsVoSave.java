package com.news.lyt.domain;

public class CommentsVoSave {
    private Integer nid;
    private Integer uid;
    private String commentstime;
    private String content;

    @Override
    public String toString() {
        return "CommentsVoSave{" +
                "nid=" + nid +
                ", uid=" + uid +
                ", commentstime='" + commentstime + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCommentstime() {
        return commentstime;
    }

    public void setCommentstime(String commentstime) {
        this.commentstime = commentstime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

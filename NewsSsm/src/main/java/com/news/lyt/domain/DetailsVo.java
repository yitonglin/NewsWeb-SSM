package com.news.lyt.domain;

import java.util.Date;
import java.util.List;

//详情界面
public class DetailsVo {
    private String title;
    private String category;
    private int lookNum;
    private int replyNum;//回复
    private List<String> text;//分段文章
    private Date time;//时间
    private String timeStr;//时间文本
    private String photo;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "DetailsVo{" +
                "title='" + title + '\'' +
                ", category=" + category +
                ", lookNum=" + lookNum +
                ", replyNum=" + replyNum +
                ", text=" + text +
                ", time=" + time +
                ", timeStr='" + timeStr + '\'' +
                '}';
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
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

    public int getLookNum() {
        return lookNum;
    }

    public void setLookNum(int lookNum) {
        this.lookNum = lookNum;
    }

    public int getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(int replyNum) {
        this.replyNum = replyNum;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }
}

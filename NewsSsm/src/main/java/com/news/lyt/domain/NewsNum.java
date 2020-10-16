package com.news.lyt.domain;


import java.util.Date;

/**
 * 最新咨询的返回格式
 */
public class NewsNum {
    private String img;
    private String title;
    private String label;
    private int message;
    private String time;

    @Override
    public String toString() {
        return "NewsNum{" +
                "img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", label='" + label + '\'' +
                ", message=" + message +
                ", time=" + time +
                '}';
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

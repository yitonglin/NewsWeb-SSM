package com.news.lyt.domain;

public class TakePhtoco {
    private String newsname;
    private String photoaddress;

    public String getNewsname() {
        return newsname;
    }

    public void setNewsname(String newsname) {
        this.newsname = newsname;
    }

    public String getPhotoaddress() {
        return photoaddress;
    }

    public void setPhotoaddress(String photoaddress) {
        this.photoaddress = photoaddress;
    }



    @Override
    public String toString() {
        return "takePhtoco{" +
                "newsname='" + newsname + '\'' +
                ", photoaddress='" + photoaddress + '\'' +
                '}';
    }
}

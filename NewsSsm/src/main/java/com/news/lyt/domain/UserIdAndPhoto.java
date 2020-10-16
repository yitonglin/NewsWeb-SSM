package com.news.lyt.domain;

public class UserIdAndPhoto {
    private int id;
    private String photo;

    @Override
    public String toString() {
        return "UserIdAndPhoto{" +
                "id=" + id +
                ", photo='" + photo + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

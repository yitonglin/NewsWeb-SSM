package com.news.lyt.domain;

public class NidById {
    private int nid;
    private int limitNum;

    @Override
    public String toString() {
        return "NidById{" +
                "nid=" + nid +
                ", limitNum=" + limitNum +
                '}';
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public int getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(int limitNum) {
        this.limitNum = limitNum;
    }
}

package com.news.lyt.domain;

import java.util.Date;

public class Comments {

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", nid=" + nid +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", commentstime=" + commentstime +
                '}';
    }


    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comments.id
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comments.nid
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    private Integer nid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comments.uid
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comments.content
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comments.commentstime
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    private Date commentstime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comments.id
     *
     * @return the value of comments.id
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comments.id
     *
     * @param id the value for comments.id
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comments.nid
     *
     * @return the value of comments.nid
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public Integer getNid() {
        return nid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comments.nid
     *
     * @param nid the value for comments.nid
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public void setNid(Integer nid) {
        this.nid = nid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comments.uid
     *
     * @return the value of comments.uid
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comments.uid
     *
     * @param uid the value for comments.uid
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comments.content
     *
     * @return the value of comments.content
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comments.content
     *
     * @param content the value for comments.content
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comments.commentstime
     *
     * @return the value of comments.commentstime
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public Date getCommentstime() {
        return commentstime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comments.commentstime
     *
     * @param commentstime the value for comments.commentstime
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public void setCommentstime(Date commentstime) {
        this.commentstime = commentstime;
    }
}
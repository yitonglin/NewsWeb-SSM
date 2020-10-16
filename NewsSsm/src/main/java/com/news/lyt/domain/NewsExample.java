package com.news.lyt.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table news
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table news
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table news
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public NewsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table news
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table news
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andNewsnameIsNull() {
            addCriterion("newsname is null");
            return (Criteria) this;
        }

        public Criteria andNewsnameIsNotNull() {
            addCriterion("newsname is not null");
            return (Criteria) this;
        }

        public Criteria andNewsnameEqualTo(String value) {
            addCriterion("newsname =", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameNotEqualTo(String value) {
            addCriterion("newsname <>", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameGreaterThan(String value) {
            addCriterion("newsname >", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameGreaterThanOrEqualTo(String value) {
            addCriterion("newsname >=", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameLessThan(String value) {
            addCriterion("newsname <", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameLessThanOrEqualTo(String value) {
            addCriterion("newsname <=", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameLike(String value) {
            addCriterion("newsname like", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameNotLike(String value) {
            addCriterion("newsname not like", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameIn(List<String> values) {
            addCriterion("newsname in", values, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameNotIn(List<String> values) {
            addCriterion("newsname not in", values, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameBetween(String value1, String value2) {
            addCriterion("newsname between", value1, value2, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameNotBetween(String value1, String value2) {
            addCriterion("newsname not between", value1, value2, "newsname");
            return (Criteria) this;
        }

        public Criteria andLooknumIsNull() {
            addCriterion("looknum is null");
            return (Criteria) this;
        }

        public Criteria andLooknumIsNotNull() {
            addCriterion("looknum is not null");
            return (Criteria) this;
        }

        public Criteria andLooknumEqualTo(Integer value) {
            addCriterion("looknum =", value, "looknum");
            return (Criteria) this;
        }

        public Criteria andLooknumNotEqualTo(Integer value) {
            addCriterion("looknum <>", value, "looknum");
            return (Criteria) this;
        }

        public Criteria andLooknumGreaterThan(Integer value) {
            addCriterion("looknum >", value, "looknum");
            return (Criteria) this;
        }

        public Criteria andLooknumGreaterThanOrEqualTo(Integer value) {
            addCriterion("looknum >=", value, "looknum");
            return (Criteria) this;
        }

        public Criteria andLooknumLessThan(Integer value) {
            addCriterion("looknum <", value, "looknum");
            return (Criteria) this;
        }

        public Criteria andLooknumLessThanOrEqualTo(Integer value) {
            addCriterion("looknum <=", value, "looknum");
            return (Criteria) this;
        }

        public Criteria andLooknumIn(List<Integer> values) {
            addCriterion("looknum in", values, "looknum");
            return (Criteria) this;
        }

        public Criteria andLooknumNotIn(List<Integer> values) {
            addCriterion("looknum not in", values, "looknum");
            return (Criteria) this;
        }

        public Criteria andLooknumBetween(Integer value1, Integer value2) {
            addCriterion("looknum between", value1, value2, "looknum");
            return (Criteria) this;
        }

        public Criteria andLooknumNotBetween(Integer value1, Integer value2) {
            addCriterion("looknum not between", value1, value2, "looknum");
            return (Criteria) this;
        }

        public Criteria andReplynumIsNull() {
            addCriterion("replynum is null");
            return (Criteria) this;
        }

        public Criteria andReplynumIsNotNull() {
            addCriterion("replynum is not null");
            return (Criteria) this;
        }

        public Criteria andReplynumEqualTo(Integer value) {
            addCriterion("replynum =", value, "replynum");
            return (Criteria) this;
        }

        public Criteria andReplynumNotEqualTo(Integer value) {
            addCriterion("replynum <>", value, "replynum");
            return (Criteria) this;
        }

        public Criteria andReplynumGreaterThan(Integer value) {
            addCriterion("replynum >", value, "replynum");
            return (Criteria) this;
        }

        public Criteria andReplynumGreaterThanOrEqualTo(Integer value) {
            addCriterion("replynum >=", value, "replynum");
            return (Criteria) this;
        }

        public Criteria andReplynumLessThan(Integer value) {
            addCriterion("replynum <", value, "replynum");
            return (Criteria) this;
        }

        public Criteria andReplynumLessThanOrEqualTo(Integer value) {
            addCriterion("replynum <=", value, "replynum");
            return (Criteria) this;
        }

        public Criteria andReplynumIn(List<Integer> values) {
            addCriterion("replynum in", values, "replynum");
            return (Criteria) this;
        }

        public Criteria andReplynumNotIn(List<Integer> values) {
            addCriterion("replynum not in", values, "replynum");
            return (Criteria) this;
        }

        public Criteria andReplynumBetween(Integer value1, Integer value2) {
            addCriterion("replynum between", value1, value2, "replynum");
            return (Criteria) this;
        }

        public Criteria andReplynumNotBetween(Integer value1, Integer value2) {
            addCriterion("replynum not between", value1, value2, "replynum");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andPhotoaddressIsNull() {
            addCriterion("photoaddress is null");
            return (Criteria) this;
        }

        public Criteria andPhotoaddressIsNotNull() {
            addCriterion("photoaddress is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoaddressEqualTo(String value) {
            addCriterion("photoaddress =", value, "photoaddress");
            return (Criteria) this;
        }

        public Criteria andPhotoaddressNotEqualTo(String value) {
            addCriterion("photoaddress <>", value, "photoaddress");
            return (Criteria) this;
        }

        public Criteria andPhotoaddressGreaterThan(String value) {
            addCriterion("photoaddress >", value, "photoaddress");
            return (Criteria) this;
        }

        public Criteria andPhotoaddressGreaterThanOrEqualTo(String value) {
            addCriterion("photoaddress >=", value, "photoaddress");
            return (Criteria) this;
        }

        public Criteria andPhotoaddressLessThan(String value) {
            addCriterion("photoaddress <", value, "photoaddress");
            return (Criteria) this;
        }

        public Criteria andPhotoaddressLessThanOrEqualTo(String value) {
            addCriterion("photoaddress <=", value, "photoaddress");
            return (Criteria) this;
        }

        public Criteria andPhotoaddressLike(String value) {
            addCriterion("photoaddress like", value, "photoaddress");
            return (Criteria) this;
        }

        public Criteria andPhotoaddressNotLike(String value) {
            addCriterion("photoaddress not like", value, "photoaddress");
            return (Criteria) this;
        }

        public Criteria andPhotoaddressIn(List<String> values) {
            addCriterion("photoaddress in", values, "photoaddress");
            return (Criteria) this;
        }

        public Criteria andPhotoaddressNotIn(List<String> values) {
            addCriterion("photoaddress not in", values, "photoaddress");
            return (Criteria) this;
        }

        public Criteria andPhotoaddressBetween(String value1, String value2) {
            addCriterion("photoaddress between", value1, value2, "photoaddress");
            return (Criteria) this;
        }

        public Criteria andPhotoaddressNotBetween(String value1, String value2) {
            addCriterion("photoaddress not between", value1, value2, "photoaddress");
            return (Criteria) this;
        }

        public Criteria andTextaddressIsNull() {
            addCriterion("textaddress is null");
            return (Criteria) this;
        }

        public Criteria andTextaddressIsNotNull() {
            addCriterion("textaddress is not null");
            return (Criteria) this;
        }

        public Criteria andTextaddressEqualTo(String value) {
            addCriterion("textaddress =", value, "textaddress");
            return (Criteria) this;
        }

        public Criteria andTextaddressNotEqualTo(String value) {
            addCriterion("textaddress <>", value, "textaddress");
            return (Criteria) this;
        }

        public Criteria andTextaddressGreaterThan(String value) {
            addCriterion("textaddress >", value, "textaddress");
            return (Criteria) this;
        }

        public Criteria andTextaddressGreaterThanOrEqualTo(String value) {
            addCriterion("textaddress >=", value, "textaddress");
            return (Criteria) this;
        }

        public Criteria andTextaddressLessThan(String value) {
            addCriterion("textaddress <", value, "textaddress");
            return (Criteria) this;
        }

        public Criteria andTextaddressLessThanOrEqualTo(String value) {
            addCriterion("textaddress <=", value, "textaddress");
            return (Criteria) this;
        }

        public Criteria andTextaddressLike(String value) {
            addCriterion("textaddress like", value, "textaddress");
            return (Criteria) this;
        }

        public Criteria andTextaddressNotLike(String value) {
            addCriterion("textaddress not like", value, "textaddress");
            return (Criteria) this;
        }

        public Criteria andTextaddressIn(List<String> values) {
            addCriterion("textaddress in", values, "textaddress");
            return (Criteria) this;
        }

        public Criteria andTextaddressNotIn(List<String> values) {
            addCriterion("textaddress not in", values, "textaddress");
            return (Criteria) this;
        }

        public Criteria andTextaddressBetween(String value1, String value2) {
            addCriterion("textaddress between", value1, value2, "textaddress");
            return (Criteria) this;
        }

        public Criteria andTextaddressNotBetween(String value1, String value2) {
            addCriterion("textaddress not between", value1, value2, "textaddress");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table news
     *
     * @mbggenerated do_not_delete_during_merge Thu Jun 25 10:47:19 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table news
     *
     * @mbggenerated Thu Jun 25 10:47:19 CST 2020
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
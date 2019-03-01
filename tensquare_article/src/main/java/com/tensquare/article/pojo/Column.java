package com.tensquare.article.pojo;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_column", schema = "tensquare_article", catalog = "")
public class Column implements Serializable {
    private String id;
    private String name;
    private String summary;
    private String userid;
    private Timestamp createtime;
    private Timestamp checktime;
    private String state;

    @Id
    @javax.persistence.Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @javax.persistence.Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @javax.persistence.Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Basic
    @javax.persistence.Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @javax.persistence.Column(name = "createtime")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Basic
    @javax.persistence.Column(name = "checktime")
    public Timestamp getChecktime() {
        return checktime;
    }

    public void setChecktime(Timestamp checktime) {
        this.checktime = checktime;
    }

    @Basic
    @javax.persistence.Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column column = (Column) o;
        return Objects.equals(id, column.id) &&
                Objects.equals(name, column.name) &&
                Objects.equals(summary, column.summary) &&
                Objects.equals(userid, column.userid) &&
                Objects.equals(createtime, column.createtime) &&
                Objects.equals(checktime, column.checktime) &&
                Objects.equals(state, column.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, summary, userid, createtime, checktime, state);
    }
}

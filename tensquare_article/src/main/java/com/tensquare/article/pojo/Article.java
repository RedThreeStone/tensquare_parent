package com.tensquare.article.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_article", schema = "tensquare_article", catalog = "")
public class Article implements Serializable {
    private String id;
    private String columnid;
    private String userid;
    private String title;
    private String content;
    private String image;
    private Timestamp createtime;
    private Timestamp updatetime;
    private String ispublic;
    private String istop;
    private Integer visits;
    private Integer thumbup;
    private Integer comment;
    private String state;
    private String channelid;
    private String url;
    private String type;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "columnid")
    public String getColumnid() {
        return columnid;
    }

    public void setColumnid(String columnid) {
        this.columnid = columnid;
    }

    @Basic
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "createtime")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "updatetime")
    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    @Basic
    @Column(name = "ispublic")
    public String getIspublic() {
        return ispublic;
    }

    public void setIspublic(String ispublic) {
        this.ispublic = ispublic;
    }

    @Basic
    @Column(name = "istop")
    public String getIstop() {
        return istop;
    }

    public void setIstop(String istop) {
        this.istop = istop;
    }

    @Basic
    @Column(name = "visits")
    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    @Basic
    @Column(name = "thumbup")
    public Integer getThumbup() {
        return thumbup;
    }

    public void setThumbup(Integer thumbup) {
        this.thumbup = thumbup;
    }

    @Basic
    @Column(name = "comment")
    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "channelid")
    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id) &&
                Objects.equals(columnid, article.columnid) &&
                Objects.equals(userid, article.userid) &&
                Objects.equals(title, article.title) &&
                Objects.equals(content, article.content) &&
                Objects.equals(image, article.image) &&
                Objects.equals(createtime, article.createtime) &&
                Objects.equals(updatetime, article.updatetime) &&
                Objects.equals(ispublic, article.ispublic) &&
                Objects.equals(istop, article.istop) &&
                Objects.equals(visits, article.visits) &&
                Objects.equals(thumbup, article.thumbup) &&
                Objects.equals(comment, article.comment) &&
                Objects.equals(state, article.state) &&
                Objects.equals(channelid, article.channelid) &&
                Objects.equals(url, article.url) &&
                Objects.equals(type, article.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, columnid, userid, title, content, image, createtime, updatetime, ispublic, istop, visits, thumbup, comment, state, channelid, url, type);
    }
}

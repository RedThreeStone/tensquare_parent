package com.tensquare.article.pojo;

import javax.persistence.Column;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_channel", schema = "tensquare_article", catalog = "")
public class Channel implements Serializable {
    private String id;
    private String name;
    private String state;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "state")
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
        Channel channel = (Channel) o;
        return Objects.equals(id, channel.id) &&
                Objects.equals(name, channel.name) &&
                Objects.equals(state, channel.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, state);
    }
}

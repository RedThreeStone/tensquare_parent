package com.tensquare.qa.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_problem")
@Data
public class Problem {
    @Id
    private String id;
    private String title;
    private String content;
    private Timestamp createtime;
    private Timestamp updatetime;
    private String userid;
    private String nickname;
    private Long visits;
    private Long thumbup;
    private Long reply;
    private String solve;
    private String replyname;
    private Timestamp replytime;



}

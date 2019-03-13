package com.tensquare.search.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "articleindex",type = "article")
@Data
public class Article {
    @Id
    private String id;

    @Field(index = true,analyzer = "ik_smart",searchAnalyzer = "ik_smart")
    private String title;

    @Field(index = true,analyzer = "ik_smart",searchAnalyzer = "ik_smart")
    private String content;

    private String state;
}

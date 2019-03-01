package com.tensquare.article.dao;

import com.tensquare.article.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ArticleDao extends JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {

    @Modifying
    @Query(value = "update tb_article a set a.thumbup=a.thumbup+1 where a.id = ?1",nativeQuery = true)
    void thumbupAdd(int articleId);


    Page<Article> findArticleByChannelidEquals(int channelId, Pageable pageable);

    Page<Article> findArticleByColumnidEquals(int columnId, Pageable pageable);
}

package com.tensquare.article.service;

import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ColumnService columnService;

    private static String REDISKEY="article_";

    @CachePut(value = "article",key = "#article.id")
    public void addArticle(Article article) {
        article.setId(idWorker.nextId() + "");
        articleDao.save(article);
        //redisTemplate.opsForValue().set(REDISKEY+article.getId(),article);
    }

    public List<Article> findAllArticle() {
        return articleDao.findAll();
    }

    @CacheEvict(value = "article",key = "#id")
    public void deleteArticleById(String id) {
        articleDao.deleteById(id);
    //    redisTemplate.delete(REDISKEY+id);
    }

    @Cacheable(value = "article",key = "#id")
    public Article getArticleById(String id) {
//        Article obj = (Article) redisTemplate.opsForValue().get("article_" + id);
//        if(obj!=null){
//            return obj;
//        }
        try {
            int a=1/0;
        }catch (Exception e){
            columnService.sendErrorMsg();
        }
        return articleDao.findById(id).get();
    }
    @CacheEvict(value = "article",key = "#article.id")
    public void updateArticle(Article article) {
        articleDao.save(article);
      //  redisTemplate.opsForValue().set(REDISKEY+article.getId(),article);

    }


    public Page findArticleForPage(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return articleDao.findAll(pageable);
    }

    public void thumbup(int articleId) {

        articleDao.thumbupAdd(articleId);
    }

    public Page<Article> findArticleByChannelIdForPage(int channelId, int pageNum, int size) {
        Pageable pageable = PageRequest.of(pageNum-1,size);
        return articleDao.findArticleByChannelidEquals(channelId,pageable);
    }

    public Page<Article> findArticleByColumnIdForPage(int columnId, int pageNum, int size) {
        Pageable pageable = PageRequest.of(pageNum-1,size);
        return articleDao.findArticleByColumnidEquals(columnId,pageable);
    }

    public void examine(String articleId){
        Article article = new Article();
        article.setId(articleId);
        article.setState("2");
        articleDao.save(article);
    }

}

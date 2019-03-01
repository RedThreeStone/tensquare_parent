package com.tensquare.article.controller;

import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.POST)
    public Result addArticle(@RequestBody Article article) {
        articleService.addArticle(article);
        return new Result();
    }

    @RequestMapping(value = "/{articledId}", method = RequestMethod.DELETE)
    public Result deleteArticle(@PathVariable("articledId") String articledId) {
        articleService.deleteArticleById(articledId);
        return new Result();
    }

    @RequestMapping(value = "/{articledId}", method = RequestMethod.PUT)
    public Result updateArticle(@RequestBody Article article, @PathVariable("articledId") String articledId) {
        articleService.updateArticle(article);
        return new Result();
    }

    @RequestMapping(value = "/{articleId}", method = RequestMethod.GET)
    public Result getArticleById(@PathVariable String articleId) {
        System.out.println(111);
        Article article = articleService.getArticleById(articleId);
        return new Result(article);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Result findAllArticle() {
        return new Result(articleService.findAllArticle());
    }

    @RequestMapping(value = "/search/{pageNum}/{pageSize}",method = RequestMethod.POST)
    public PageResult<Article> search(@PathVariable int pageNum, @PathVariable int pageSize){
        Page page=articleService.findArticleForPage(pageNum,pageSize);
        return new PageResult<Article>(page.getTotalElements(),page.getContent());
    }

    @RequestMapping(value = "/thumbup{articleId}",method = RequestMethod.PUT)
    public Result thumbup(@PathVariable int articleId){
        articleService.thumbup(articleId);
        return new Result();
    }
    @RequestMapping(value = "/channel/{channelId}/{pageNum}/{size}",method = RequestMethod.POST)
    public PageResult<Article> findArticleByChannelIdForPage(@PathVariable int channelId,
                                                             @PathVariable int pageNum,
                                                             @PathVariable int size){
        Page<Article> page=articleService.findArticleByChannelIdForPage(channelId,pageNum,size);
        return  new PageResult<Article>(page.getTotalElements(),page.getContent());

    }

    @RequestMapping(value = "/column/{columnId}/{pageNum}/{size}",method = RequestMethod.POST)
    public PageResult<Article> findArticleByColumnIdForPage(@PathVariable int columnId,
                                                             @PathVariable int pageNum,
                                                             @PathVariable int size){
        Page<Article> page=articleService.findArticleByColumnIdForPage(columnId,pageNum,size);
        return  new PageResult<Article>(page.getTotalElements(),page.getContent());

    }

    @RequestMapping("/examine/{articleId}")
    public Result examine(@PathVariable String articleId){
        articleService.examine(articleId);
        return new Result();
    }
}

package com.tensquare.search.controller;

import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.SearchService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/article/search")
public class SearchController {
    @Autowired
    private SearchService searchService;
    @RequestMapping(value = "/{page}/{size}",method = RequestMethod.POST)
    public PageResult findArticleForPage(@RequestBody Article article, @PathVariable int page, @PathVariable int size){
        Page<Article> pageObj =searchService.findArticleForPage(article,page,size);
        PageResult<Article> result = new PageResult<Article>();
        long totalElements = pageObj.getTotalElements();
        List<Article> content = pageObj.getContent();
        result.setRows(content);
        result.setTotal(totalElements);
        return  result;
    }
}

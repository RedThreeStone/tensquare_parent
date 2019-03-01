package com.tensquare.article.controller;


import com.tensquare.article.pojo.Column;
import com.tensquare.article.service.ColumnService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/column")
public class ColumnController {
    @Autowired
    private ColumnService columnService;

    @RequestMapping(method = RequestMethod.POST)
    public Result addColumn(@RequestBody Column column) {
        columnService.addColumn(column);
        return new Result();
    }

    @RequestMapping(value = "/{columndId}", method = RequestMethod.DELETE)
    public Result deleteColumn(@PathVariable("columndId") String columndId) {
        columnService.deleteColumnById(columndId);
        return new Result();
    }

    @RequestMapping(value = "/{columndId}", method = RequestMethod.PUT)
    public Result updateColumn(@RequestBody Column column, @PathVariable("columndId") String columndId) {
        columnService.updateColumn(column);
        return new Result();
    }

    @RequestMapping(value = "/{columnId}", method = RequestMethod.GET)
    public Result getColumnById(@PathVariable String columnId) {
        return new Result(columnService.getColumnById(columnId));
    }

    @RequestMapping(method = RequestMethod.GET)
    public Result findAllColumn() {
        return new Result(columnService.findAllColumn());
    }
    @RequestMapping(value = "/search/{pageNum}/{pageSize}",method = RequestMethod.POST)
    public PageResult<Column> search(@PathVariable int pageNum, @PathVariable int pageSize){
        Page page=columnService.findColumnForPage(pageNum,pageSize);
        return new PageResult<Column>(page.getTotalElements(),page.getContent());
    }

}

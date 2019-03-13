package com.tensquare.spit.controller;

import com.tensquare.spit.pojo.Spit;
import com.tensquare.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/spit")
public class SpitController {
    @Autowired
    private SpitService spitService;

    @RequestMapping(method = RequestMethod.POST)
    public Result spit(@RequestBody Spit spit){
        Spit spit1 = spitService.addSpit(spit);
        return new Result(true, StatusCode.OK,"保存成功",spit1);
    }
    @RequestMapping(method = RequestMethod.GET)
    public Result findSpit(){
        List<Spit> spits = spitService.findSpit();
        return new Result(true,StatusCode.OK,"查询成功",spits);
    }

    @RequestMapping(value = "/{spitId}",method = RequestMethod.GET)
    public Result findSpitById(@PathVariable String spitId){
        Spit spitById = spitService.getSpitById(spitId);
        return new Result(true,StatusCode.OK,"查询成功",spitById);
    }
    @RequestMapping(value = "/{spitId}",method = RequestMethod.PUT)
    public Result updateSpit(@RequestBody Spit spit,@PathVariable String spitId){
        spit.set_id(spitId);
        spitService.updateSpit(spit);
        return new Result(true,StatusCode.OK,"更新成功");
    }

    @RequestMapping(value = "/{spitId}",method = RequestMethod.DELETE)
    public Result deleteSpit(@PathVariable String spitId){
        spitService.deleteSpit(spitId);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @RequestMapping(value = "/thumbup/{spitId}",method = RequestMethod.PUT)
    public Result thumbupSpit(@PathVariable String spitId){
        spitService.spitThumbup(spitId);
        return  new Result(true,StatusCode.OK,"点赞成功");
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result searchSpit(@RequestBody Spit spit){
        List<Spit> spits = spitService.searchSpit(spit);
        return new Result(true,StatusCode.OK,"查询成功",spits);
    }
    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public PageResult searchSpitForPage(@RequestBody Spit spit,@PathVariable int page,@PathVariable  int size){
        PageResult pageResult = spitService.searchSpitForPaging(spit, page, size);
        return pageResult;
    }

    @RequestMapping(value = "/comment/{parentId}/{page}/{size}",method = RequestMethod.GET)
    public PageResult searchSpitByParentIdForPage(@PathVariable String parentId,@PathVariable int page,@PathVariable  int size){
        PageResult pageResult = spitService.searchSpitByParentIdForPaging(parentId,page,size);
        return pageResult;
    }
}

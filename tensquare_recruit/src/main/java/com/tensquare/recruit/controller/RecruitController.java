package com.tensquare.recruit.controller;

import com.tensquare.recruit.pojo.Recruit;
import com.tensquare.recruit.service.RecruitService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/recruit")
public class RecruitController {
    @Autowired
    private RecruitService recruitService;

    @RequestMapping(method = RequestMethod.POST)
    public Result addRecruit(@RequestBody Recruit recruit) {
        recruitService.addRecruit(recruit);
        return new Result();
    }

    @RequestMapping(value = "/{recruitdId}", method = RequestMethod.DELETE)
    public Result deleteRecruit(@PathVariable("recruitdId") String recruitdId) {
        recruitService.deleteRecruitById(recruitdId);
        return new Result();
    }

    @RequestMapping(value = "/{recruitdId}", method = RequestMethod.PUT)
    public Result updateRecruit(@RequestBody Recruit recruit, @PathVariable("recruitdId") String recruitdId) {
        recruitService.updateRecruit(recruit);
        return new Result();
    }

    @RequestMapping(value = "/{recruitId}", method = RequestMethod.GET)
    public Result getRecruitById(@PathVariable String recruitId) {
        return new Result(recruitService.getRecruitById(recruitId));
    }

    @RequestMapping(method = RequestMethod.GET)
    public Result findAllRecruit() {
        return new Result(recruitService.findAllRecruit());
    }

    @RequestMapping(value = "/search/{pageNum}/{pageSize}",method = RequestMethod.POST)
    public Result findRecruitForPage(@RequestBody Recruit recruit,
                                     @PathVariable int pageNum,@PathVariable int pageSize){
        Page<Recruit> page = recruitService.findRecruitForPage(recruit, pageNum, pageSize);
        PageResult<Recruit> pageResult = new PageResult<>(page.getTotalElements(), page.getContent());
        return  new Result(pageResult);
    }
    @RequestMapping(value = "/search/recommend")
    public Result findHot(){
        return new Result(recruitService.findHots());
    }
    @RequestMapping(value = "/search/newList")
    public Result findNew(){
        return new Result(recruitService.findNewList());
    }
}

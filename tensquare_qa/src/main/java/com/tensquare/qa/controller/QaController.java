package com.tensquare.qa.controller;

import com.tensquare.qa.pojo.Problem;
import com.tensquare.qa.service.QaService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/qa")
public class QaController {
    @Autowired
    private QaService qaService;

    @RequestMapping("/problem/newList/{label}/{page}/{size}")
    public Result newList(@PathVariable String label,@PathVariable int page,@PathVariable int size){
        Page<Problem> problemPage=qaService.newProblemList(label,page,size);
        System.out.println(problemPage.getContent());
        PageResult<Problem> problemPageResult = new PageResult<>(problemPage.getTotalElements(), problemPage.getContent());
        return new Result(problemPageResult);
    }

}

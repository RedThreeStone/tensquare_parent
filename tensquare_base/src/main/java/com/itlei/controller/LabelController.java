package com.itlei.controller;

import com.itlei.pojo.Label;
import com.itlei.service.LabelService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;
    @RequestMapping(method = RequestMethod.POST)
    public Result addLabel(@RequestBody Label label){
        labelService.addLabel(label);
        return new Result();
    }
    @RequestMapping(value = "/{labeldId}",method = RequestMethod.DELETE)
    public Result deleteLabel(@PathVariable("labeldId") String labeldId){
        labelService.deleteLabelById(labeldId);
        return new Result();
    }
    @RequestMapping(value = "/{labeldId}",method = RequestMethod.PUT)
    public Result updateLabel(@RequestBody Label label,@PathVariable("labeldId") String labeldId){
        labelService.updateLabel(label);
        return new Result();
    }
    @RequestMapping(value = "/{labelId}",method = RequestMethod.GET)
    public Result getLabelById(@PathVariable String labelId){
        return new Result(labelService.getLabelById(labelId));
    }
    @RequestMapping(method = RequestMethod.GET)
    public Result findAllLabel(){
        return new Result(labelService.findAllLabel());
    }
}

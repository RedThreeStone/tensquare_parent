package com.tensquare.recruit.controller;

import com.tensquare.recruit.pojo.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;

    @RequestMapping(method = RequestMethod.POST)
    public Result addEnterprise(@RequestBody Enterprise enterprise) {
        enterpriseService.addEnterprise(enterprise);
        return new Result();
    }

    @RequestMapping(value = "/{enterprisedId}", method = RequestMethod.DELETE)
    public Result deleteEnterprise(@PathVariable("enterprisedId") String enterprisedId) {
        enterpriseService.deleteEnterpriseById(enterprisedId);
        return new Result();
    }

    @RequestMapping(value = "/{enterprisedId}", method = RequestMethod.PUT)
    public Result updateEnterprise(@RequestBody Enterprise enterprise, @PathVariable("enterprisedId") String enterprisedId) {
        enterpriseService.updateEnterprise(enterprise);
        return new Result();
    }

    @RequestMapping(value = "/{enterpriseId}", method = RequestMethod.GET)
    public Result getEnterpriseById(@PathVariable String enterpriseId) {
        return new Result(enterpriseService.getEnterpriseById(enterpriseId));
    }

    @RequestMapping(method = RequestMethod.GET)
    public Result findAllEnterprise() {
        return new Result(enterpriseService.findAllEnterprise());
    }
    
}

package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.EnterpriseDao;
import com.tensquare.recruit.pojo.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service
public class EnterpriseService {
    @Autowired
    private EnterpriseDao enterpriseDao;
    @Autowired
    private IdWorker idWorker;

    public void addEnterprise(Enterprise enterprise) {
        enterprise.setId(idWorker.nextId() + "");
        enterpriseDao.save(enterprise);
    }

    public List<Enterprise> findAllEnterprise() {
        return enterpriseDao.findAll();
    }

    public void deleteEnterpriseById(String id) {
        enterpriseDao.deleteById(id);
    }

    public Enterprise getEnterpriseById(String id) {
        return enterpriseDao.findById(id).get();
    }

    public void updateEnterprise(Enterprise enterprise) {
        enterpriseDao.save(enterprise);
    }


}

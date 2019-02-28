package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.RecruitDao;
import com.tensquare.recruit.pojo.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service
public class RecruitService {
    @Autowired
    private RecruitDao recruitDao;
    @Autowired
    private IdWorker idWorker;

    public void addRecruit(Recruit recruit) {
        recruit.setId(idWorker.nextId() + "");
        recruitDao.save(recruit);
    }

    public List<Recruit> findAllRecruit() {
        return recruitDao.findAll();
    }

    public void deleteRecruitById(String id) {
        recruitDao.deleteById(id);
    }

    public Recruit getRecruitById(String id) {
        return recruitDao.findById(id).get();
    }

    public void updateRecruit(Recruit recruit) {
        recruitDao.save(recruit);
    }

    public Page<Recruit> findRecruitForPage(Recruit recruit, int pageNum, int pageSize){
        Pageable pageable = PageRequest.of(pageNum-1,pageSize) ;
        return recruitDao.findByConditionLikeAndAddressLike(recruit.getCondition(),
                recruit.getAddress(),pageable);
    }
    public List<Recruit> findHots(){
        return recruitDao.findTop6ByStateIsOrderByIdDesc("1");
    }
    public List<Recruit> findNewList(){
        return recruitDao.findTop12ByStateNotOrderByCreatetimeDesc("1");
    }


}

package com.tensquare.spit.service;

import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.Spit;
import entity.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service
public class SpitService {
    @Autowired
    private SpitDao spitDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Spit addSpit(Spit spit){
        spit.set_id(idWorker.nextId()+"");
        return  spitDao.save(spit);
    }

    public void updateSpit(Spit spit){
        spitDao.save(spit);
    }

    public void deleteSpit(String id){
        spitDao.deleteById(id);
    }
    public List<Spit> findSpit(){
        return  spitDao.findAll();
    }

    public Spit getSpitById(String id){

        return spitDao.findById(id).get();
    }

    public void spitThumbup(String spitId){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(spitId));
        Update update = new Update();
        update.inc("thumbup",1);
        mongoTemplate.updateFirst(query,update,"spit");
    }

    public List<Spit> searchSpit(Spit spit){
        Query query = new Query();
        if(StringUtils.isNotEmpty(spit.get_id())){
            query.addCriteria(Criteria.where("_id").is(spit.get_id()));
        }
        if (StringUtils.isNotEmpty(spit.getContent())){
            query.addCriteria(Criteria.where("content").regex(spit.getContent()));
        }
        return (List<Spit>)mongoTemplate.find(query, spit.getClass(), "spit");

    }

  public PageResult searchSpitForPaging(Spit spit,int pageNum,int pageSize){
        Query query = new Query();
        if(StringUtils.isNotEmpty(spit.get_id())){
            query.addCriteria(Criteria.where("_id").is(spit.get_id()));
        }
        if (StringUtils.isNotEmpty(spit.getContent())){
            query.addCriteria(Criteria.where("content").regex(spit.getContent()));
        }
        //pageNum  0 开始
      List<Spit> spits = mongoTemplate.find(query.with(PageRequest.of(pageNum-1,pageSize,new Sort(Sort.Direction.ASC,"_id"))), Spit.class, "spit");
        long count = mongoTemplate.count(query, "spit");
        return new PageResult(count,spits);
    }

    public PageResult searchSpitByParentIdForPaging(String parentId,int pageNum,int pageSize){
        Query query = new Query();
        query.addCriteria(Criteria.where("parentid").is(parentId));
        long count = mongoTemplate.count(query, "spit");
        List<Spit> spits = mongoTemplate.find(query.with(PageRequest.of(pageNum-1,pageSize,new Sort(Sort.Direction.ASC,"_id"))), Spit.class, "spit");
        return new PageResult(count,spits);
    }

}

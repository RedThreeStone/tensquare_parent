package com.tensquare.article.service;

import com.tensquare.article.dao.ColumnDao;
import com.tensquare.article.pojo.Column;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ColumnService {
    @Autowired
    private ColumnDao columnDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private RedisTemplate redisTemplate;

    private static String MSGKEY="msg_";
    public void addColumn(Column column) {
        column.setId(idWorker.nextId() + "");
        columnDao.save(column);
    }

    public List<Column> findAllColumn() {
        return columnDao.findAll();
    }

    public void deleteColumnById(String id) {
        columnDao.deleteById(id);
    }

    public Column getColumnById(String id) {
        return columnDao.findById(id).get();
    }

    public void updateColumn(Column column) {
        columnDao.save(column);
    }
    public Page findColumnForPage(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return columnDao.findAll(pageable);
    }

    public void sendErrorMsg(){
        System.out.println("啊啊啊 出错啦");
        String msgCache  = (String) redisTemplate.opsForValue().get(MSGKEY + "异常短信2");
        if(StringUtils.isNotEmpty(msgCache)){
            return;
        }else {
            redisTemplate.opsForValue().set(MSGKEY + "异常短信2","啊啊啊出错了",600, TimeUnit.SECONDS);
        }
    }
}

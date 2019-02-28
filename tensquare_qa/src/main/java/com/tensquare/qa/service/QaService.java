package com.tensquare.qa.service;

import com.tensquare.qa.dao.ProblemDao;
import com.tensquare.qa.dao.ReplyDao;
import com.tensquare.qa.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import util.IdWorker;

@Service
public class QaService {
    @Autowired
    private ProblemDao problemDao;
    @Autowired
    private ReplyDao replyDao;
    @Autowired
    private IdWorker idWorker;


    public Page<Problem> newProblemList(String label, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return problemDao.findProblemNewList(label,pageRequest);
    }
}

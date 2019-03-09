package com.tensquare.spit.service;

import com.tensquare.qa.dao.ProblemDao;
import com.tensquare.qa.dao.ReplyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

@Service
public class SpitService {
    @Autowired
    private ProblemDao problemDao;
    @Autowired
    private ReplyDao replyDao;
    @Autowired
    private IdWorker idWorker;



}

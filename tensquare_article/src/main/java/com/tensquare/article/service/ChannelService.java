package com.tensquare.article.service;

import com.tensquare.article.dao.ChannelDao;
import com.tensquare.article.pojo.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service
public class ChannelService {
    @Autowired
    private ChannelDao channelDao;
    @Autowired
    private IdWorker idWorker;

    public void addChannel(Channel channel) {
        channel.setId(idWorker.nextId() + "");
        channelDao.save(channel);
    }

    public List<Channel> findAllChannel() {
        return channelDao.findAll();
    }

    public void deleteChannelById(String id) {
        channelDao.deleteById(id);
    }

    public Channel getChannelById(String id) {
        return channelDao.findById(id).get();
    }

    public void updateChannel(Channel channel) {
        channelDao.save(channel);
    }

    public Page findChannelForPage(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return channelDao.findAll(pageable);
    }
}

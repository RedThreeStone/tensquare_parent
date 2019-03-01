package com.tensquare.article.controller;


import com.tensquare.article.pojo.Channel;
import com.tensquare.article.service.ChannelService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/channel")
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @RequestMapping(method = RequestMethod.POST)
    public Result addChannel(@RequestBody Channel channel) {
        channelService.addChannel(channel);
        return new Result();
    }

    @RequestMapping(value = "/{channeldId}", method = RequestMethod.DELETE)
    public Result deleteChannel(@PathVariable("channeldId") String channeldId) {
        channelService.deleteChannelById(channeldId);
        return new Result();
    }

    @RequestMapping(value = "/{channeldId}", method = RequestMethod.PUT)
    public Result updateChannel(@RequestBody Channel channel, @PathVariable("channeldId") String channeldId) {
        channelService.updateChannel(channel);
        return new Result();
    }

    @RequestMapping(value = "/{channelId}", method = RequestMethod.GET)
    public Result getChannelById(@PathVariable String channelId) {
        return new Result(channelService.getChannelById(channelId));
    }

    @RequestMapping(method = RequestMethod.GET)
    public Result findAllChannel() {
        return new Result(channelService.findAllChannel());
    }
    @RequestMapping(value = "/search/{pageNum}/{pageSize}",method = RequestMethod.POST)
    public PageResult<Channel> search(@PathVariable int pageNum, @PathVariable int pageSize){
        Page page=channelService.findChannelForPage(pageNum,pageSize);
        return new PageResult<Channel>(page.getTotalElements(),page.getContent());
    }

}

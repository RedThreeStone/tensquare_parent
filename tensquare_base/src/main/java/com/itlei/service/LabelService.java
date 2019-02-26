package com.itlei.service;

import com.itlei.dao.LabelDao;
import com.itlei.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    public void addLabel(Label label) {
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }

    public List<Label> findAllLabel() {
        return labelDao.findAll();
    }

    public void deleteLabelById(String id) {
        labelDao.deleteById(id);
    }

    public Label getLabelById(String id) {
        return labelDao.findById(id).get();
    }

    public void updateLabel(Label label){
        labelDao.save(label);
    }


}

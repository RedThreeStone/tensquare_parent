package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.Predicate;
import java.util.LinkedList;
import java.util.List;

@Service
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    public void addLabel(Label label) {
        label.setId(idWorker.nextId() + "");
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

    public void updateLabel(Label label) {
        labelDao.save(label);
    }

    public List<Label> findLabelByClause(Label label) {
        return labelDao.findAll((Specification<Label>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> params = new LinkedList<Predicate>();
            if (StringUtils.isNotEmpty(label.getLabelname())) {
                Predicate labelname = criteriaBuilder.like(root.get("labelname").as(String.class), "%"+label.getLabelname()+"%");
                params.add(labelname);
            }
            if (StringUtils.isNotEmpty(label.getRecommend())) {
                Predicate recommend = criteriaBuilder.equal(root.get("recommend").as(String.class), label.getRecommend());
                params.add(recommend);
            }
            return criteriaBuilder.and(params.toArray(new Predicate[params.size()]));

        });
    }

    public Page<Label> findLabelForPage(Label label,int pageNum,int pageSize){
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return labelDao.findAll((Specification<Label>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> params = new LinkedList<Predicate>();
            if (StringUtils.isNotEmpty(label.getLabelname())) {
                Predicate labelname = criteriaBuilder.like(root.get("labelname").as(String.class), "%"+label.getLabelname()+"%");
                params.add(labelname);
            }
            if (StringUtils.isNotEmpty(label.getRecommend())) {
                Predicate recommend = criteriaBuilder.equal(root.get("recommend").as(String.class), label.getRecommend());
                params.add(recommend);
            }
            return criteriaBuilder.and(params.toArray(new Predicate[params.size()]));

        },pageable);
    }


}

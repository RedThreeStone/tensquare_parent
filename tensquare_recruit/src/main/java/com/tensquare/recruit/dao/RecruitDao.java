package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Recruit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RecruitDao extends JpaRepository<Recruit,String>, JpaSpecificationExecutor<Recruit> {
    public Page<Recruit> findByConditionLikeAndAddressLike(String condition, String address, Pageable pageable);

    public List<Recruit> findTop6ByStateIsOrderByIdDesc(String state);

    public List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);
}

package com.tensquare.qa.dao;


import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ProblemDao extends JpaRepository<Problem,String>, JpaSpecificationExecutor<Problem> {

    @Query(value = "select * from tb_pl  pl LEFT JOIN tb_problem pr ON pl.problemid = pr.id where pl.labelid=?",nativeQuery = true)
    Page<Problem> findProblemNewList(String label, Pageable pageable);
}

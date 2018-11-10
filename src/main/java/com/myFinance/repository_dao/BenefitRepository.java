package com.myFinance.repository_dao;

import com.myFinance.entity.BenefitItem;
import com.myFinance.entity.TransactionItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BenefitRepository extends CrudRepository <BenefitItem, Long> {

    /*****************************
     * Find User By ID
     * ***************************/
    BenefitItem findById(Long id);
}

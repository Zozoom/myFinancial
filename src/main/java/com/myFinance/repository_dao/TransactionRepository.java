package com.myFinance.repository_dao;

import com.myFinance.entity.TransactionItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TransactionRepository extends CrudRepository <TransactionItem, Long> {

    /*****************************
     * Find User By ID
     * ***************************/
    TransactionItem findById(Long id);

    /*****************************
     * Find User By TransactionNumber
     * ***************************/
    TransactionItem findByTransactionNumber(int transactionNumber);


}

package com.myFinance.repository_dao;

import com.myFinance.entity.TransactionItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TransactionRepository extends CrudRepository <TransactionItem, Long> {

    /*****************************
     * Find User By ID
     * ***************************/
    TransactionItem findById(Long id);

    /*****************************
     * Get back All the Transaction from database
     * ***************************/
    List<TransactionItem> findAll();

    /*****************************
     * Get back the last 200 Transaction from database
     * ***************************/
    String queryWithLimit = "SELECT * FROM transaction_items order by item_creation_date desc limit 200";
    @Query(value = queryWithLimit, nativeQuery = true)
    List<TransactionItem> getLastHundredElements();
}

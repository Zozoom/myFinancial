package com.myFinance.service;

import com.myFinance.entity.TransactionItem;

import java.util.List;

public interface TransactionItemService {

    /**
     * Transactions
     * */
    Boolean makeTransaction (TransactionItem item);

    List<TransactionItem> getAllTransaction ();

    List<TransactionItem> getLastXTransaction ();

    Integer getAllIncome ();

    Integer getAllExpense ();

    /****************************
     * Todo section Start here
     * **************************/

    Integer getkBudge();

    Integer getZBudge();

    Integer getcBudge();

    Integer getsBudge();

    Integer getkBudgeLast();

    Integer getZBudgeLast();

    Integer getcBudgeLast();

    Integer getsBudgeLast();

    /****************************
     * Todo section Ends here
     * **************************/

    String getActualYearAndMonth();

    String deleteTransaction (TransactionItem item);

    String modifyTransaction (TransactionItem item);

}

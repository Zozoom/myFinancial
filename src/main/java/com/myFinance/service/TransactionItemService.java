package com.myFinance.service;

import com.myFinance.entity.TransactionItem;

public interface TransactionItemService {

    String makeTransaction (TransactionItem item);

    String deleteTransaction (TransactionItem item);

    String modifyTransaction (TransactionItem item);

    TransactionItem getTransactionbyId ();
}

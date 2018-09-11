package com.myFinance.entity;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name="transactionItems" )
public class TransactionItem {

    public enum Direction {
        Income("Income"),
        Expense("Expense"),
        Savings("Savings");

        private final String direction;

        Direction(String direction) {
            this.direction = direction;
        }

        public String getDirection() {
            return direction;
        }
    }

    public enum Currency {
        Huf("Huf"),
        Euro("Euro"),
        Dollar("Dollar");

        private final String currency;

        Currency(String currency) {
            this.currency = currency;
        }

        public String getCurrency() {
            return currency;
        }
    }

    @Id
    @GeneratedValue
    @Column(name = "ID", unique=true, nullable=false)
    private Long id;

    @Column(name = "TransactionNumber", unique=true, nullable=false)
    private int transactionNumber;

    @Column(name = "Direction", nullable=false)
    private String direction;

    @Column(name = "Currency", nullable=false)
    private String currency;

    @Column(name = "Quantity", nullable=false, length = 8)
    private String quantity;

    @Column(name = "Date", nullable=false)
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    @Override
    public String toString() {
        return "TransactionItem{" +
                "id=" + id +
                ", transactionNumber=" + transactionNumber +
                ", direction='" + direction + '\'' +
                ", currency='" + currency + '\'' +
                ", quantity='" + quantity + '\'' +
                ", date=" + date +
                '}';
    }
}


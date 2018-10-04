package com.myFinance.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name="transactionItems" )
public class TransactionItem {

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

    @Column(name = "Comment")
    private String comment;

    @Column(name = "Category", nullable=false)
    private String category;

    @Column(name = "Cards", nullable=false)
    private String cards;

    @Column(name = "Quantity", nullable=false, length = 8)
    private String quantity;

    @Column(name = "CreationDate", nullable=false)
    private String creationDate;

    @Column(name = "ItemCreationDate", nullable=false)
    private Date itemCreationDate;

    /**
     * Direction of the Transaction
     * */
    public enum Direction {
        Income("Income"),
        Expense("Expense");

        private final String direction;

        Direction(String direction) {
            this.direction = direction;
        }

        public String getDirection() {
            return direction;
        }
    }

    /**
     * Card which card was effected by the driection.
     * */
    public enum Cards {
        Kriszti("Kriszti"),
        Zoli("Zoli"),
        Savings("Savings"),
        Credit("Credit");

        private final String cards;

        Cards(String cards) {
            this.cards = cards;
        }

        public String getCards() {
            return cards;
        }
    }

    /**
     * Category of the transaction, eg.: Shopping.
     * */
    public enum Category {
        Lunch("Lunch"),
        Food("Food"),
        ClothesAndApparel("ClothesAndApparel"),
        HealthCare("HealthCare"),
        Electronics("Electronics"),
        Games("Games"),
        Salary("Salary"),
        Transfers("Transfers"),
        Payment("Payment"),
        Internet("Internet"),
        Telephone("Telephone"),
        Rent("Rent"),
        Tickets("Tickets"),
        Cash("Cash"),
        Entertainment("Entertainment"),
        House("House"),
        CarGas("CarGas"),
        Loan("Loan"),
        CarMaintenance("CarMaintenance"),
        Other("Other");

        private final String category;

        Category(String category) {
            this.category = category;
        }

        public String getCategory() {
            return category;
        }
    }

    /**
     * Currency of the Transaction. (Hidden)
     * */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCards() {
        return cards;
    }

    public void setCards(String cards) {
        this.cards = cards;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Date getItemCreationDate() {
        return itemCreationDate;
    }

    public void setItemCreationDate(Date itemCreationDate) {
        this.itemCreationDate = itemCreationDate;
    }

    @Override
    public String toString() {
        return "TransactionItem{" +
                "id=" + id +
                ", transactionNumber=" + transactionNumber +
                ", direction='" + direction + '\'' +
                ", currency='" + currency + '\'' +
                ", comment='" + comment + '\'' +
                ", category='" + category + '\'' +
                ", cards='" + cards + '\'' +
                ", quantity='" + quantity + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", itemCreationDate=" + itemCreationDate +
                '}';
    }
}


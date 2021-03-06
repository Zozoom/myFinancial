package com.myFinance.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name="transactionItems" )
public @Data class TransactionItem {

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

}


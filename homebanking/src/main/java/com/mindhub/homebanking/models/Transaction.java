package com.mindhub.homebanking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String originHolder;
    private String originAccount;
    private TransactionType type;
    private double amount;
    private String description;
    private String numberDescription;
    private String destinationHolder;
    private String destinationAccount;
    private double balanceAccount;
    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    //CONSTRUCTOR
    public Transaction() { }

    public Transaction(Account account, String originHolder, String originAccount, TransactionType type, double amount, String description, String numberDescription, String destinationHolder, String destinationAccount, double balanceAccount, LocalDateTime creationDate) {
        this.account = account;
        this.originHolder = originHolder;
        this.originAccount = originAccount;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.numberDescription = numberDescription;
        this.destinationHolder = destinationHolder;
        this.destinationAccount = destinationAccount;
        this.balanceAccount = balanceAccount;
        this.creationDate = creationDate;
    }

    //GETTERS
    public Long getId() {return id;}
    public String getOriginHolder() {return originHolder;}
    public String getOriginAccount() {return originAccount;}
    public TransactionType getType() {return type;}
    public double getAmount() {return amount;}
    public String getDescription() {return description;}
    public String getNumberDescription() {return numberDescription;}
    public String getDestinationHolder() {return destinationHolder;}
    public String getDestinationAccount() {return destinationAccount;}
    public double getBalanceAccount() {return balanceAccount;}
    public LocalDateTime getCreationDate() {return creationDate;}

    @JsonIgnore
    public Account getAccount() {return account;}

    //SETTERS
    public void setId(Long id) {this.id = id;}
    public void setOriginHolder1(String originHolder) {this.originHolder = originHolder;}
    public void setOriginAccount(String originAccount) {this.originAccount = originAccount;}
    public void setType(TransactionType type) {this.type = type;}
    public void setAmount(double amount) {this.amount = amount;}
    public void setDescription(String description) {this.description = description;}
    public void setNumberDescription(String numberDescription) {this.numberDescription = numberDescription;}
    public void setDestinationHolder(String destinationHolder) {this.destinationHolder = destinationHolder;}
    public void setDestinationAccount(String destinationAccount) {this.destinationAccount = destinationAccount;}
    public void setBalanceAccount(double balanceAccount) {this.balanceAccount = balanceAccount;}
    public void setCreationDate(LocalDateTime creationDate) {this.creationDate = creationDate;}
    public void setAccount(Account account) {this.account = account;}
}

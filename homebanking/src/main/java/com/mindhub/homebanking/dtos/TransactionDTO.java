package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.models.TransactionType;

import java.time.LocalDateTime;

public class TransactionDTO {

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
    private Account account;

    //CONSTRUCTOR
    public TransactionDTO() { }

    public TransactionDTO(Transaction transaction) {
        this.id = transaction.getId();
        this.account = transaction.getAccount();
        this.originHolder = transaction.getOriginHolder();
        this.originAccount = transaction.getOriginAccount();
        this.type = transaction.getType();
        this.amount = transaction.getAmount();
        this.description = transaction.getDescription();
        this.numberDescription = transaction.getNumberDescription();
        this.destinationHolder = transaction.getDestinationHolder();
        this.destinationAccount = transaction.getDestinationAccount();
        this.balanceAccount = transaction.getBalanceAccount();
        this.creationDate = transaction.getCreationDate();
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

}

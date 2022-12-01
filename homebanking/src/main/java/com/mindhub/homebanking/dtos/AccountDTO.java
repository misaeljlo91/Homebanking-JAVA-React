package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.AccountType;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AccountDTO {
    private Long id;
    private String holder;
    private String number;
    private AccountType type;
    private LocalDateTime creationDate;
    private double balance;
    private Set<TransactionDTO> transactions = new HashSet<>();

    //CONSTRUCTOR
    public AccountDTO() { }

    public AccountDTO(Account account) {
        this.id = account.getId();
        this.holder = account.getHolder();
        this.number = account.getNumber();
        this.type = account.getType();
        this.creationDate = account.getCreationDate();
        this.balance = account.getBalance();
        this.transactions = account.getTransactions().stream().map(TransactionDTO::new).collect(Collectors.toSet());
    }

    //GETTERS
    public Long getId() {return id;}
    public String getHolder() {return holder;}
    public String getNumber() {return number;}
    public AccountType getType() {return type;}
    public LocalDateTime getCreationDate() {return creationDate;}
    public double getBalance() {return balance;}
    public Set<TransactionDTO> getTransactions() {return transactions;}

    //SETTERS
    public void setId(Long id) {this.id = id;}
    public void setHolder(String holder) {this.holder = holder;}
    public void setNumber(String number) {this.number = number;}
    public void setType(AccountType type) {this.type = type;}
    public void setCreationDate(LocalDateTime creationDate) {this.creationDate = creationDate;}
    public void setBalance(double balance) {this.balance = balance;}
}

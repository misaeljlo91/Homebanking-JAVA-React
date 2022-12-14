package com.mindhub.homebanking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String holder;
    private String number;
    private AccountType type;
    private LocalDateTime creationDate;
    private double balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, orphanRemoval = true)
    Set<Transaction> transactions = new HashSet<>();

    public Account() { }

    public Account(Client client, String number, AccountType type, LocalDateTime creationDate, double balance) {
        this.client = client;
        this.holder = client.getFirstName() + " " + client.getLastName();
        this.number = number;
        this.type = type;
        this.creationDate = creationDate;
        this.balance = balance;
    }

    //GETTERS
    public Long getId() {return id;}
    public String getHolder() {return holder;}
    public String getNumber() {return number;}
    public AccountType getType() {return type;}
    public LocalDateTime getCreationDate() {return creationDate;}
    public double getBalance() {return balance;}
    public Set<Transaction> getTransactions() {return transactions;}

    @JsonIgnore
    public Client getClient() {return client;}

    //SETTERS
    public void setId(Long id) {this.id = id;}
    public void setHolder(String holder) {this.holder = holder;}
    public void setNumber(String number) {this.number = number;}
    public void setType(AccountType type) {this.type = type;}
    public void setCreationDate(LocalDateTime creationDate) {this.creationDate = creationDate;}
    public void setBalance(double balance) {this.balance = balance;}
    public void setClient(Client client) {this.client = client;}
}

package org.example;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name , double balance){
        setName(name);
        setBalance(balance);
    }

    public void decreaseBalance(double amount){
        setBalance(getBalance()-amount);
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }
}

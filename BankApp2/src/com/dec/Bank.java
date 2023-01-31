package com.dec;
import java.util.ArrayList;


public class Bank {
    //Account number creator

    private static int accountCounter = 0001;
    private static double CHARGES = 1.0;
    private static double IR = 0.7;
    //collection of accounts
    private ArrayList<Account> accounts;

    public Bank(){
        accounts = new ArrayList<>();
    }
    public  void addAccount(Account account){
        this.accounts.add(account);
    }
    public Account getAccount(int accountNumber){
        for(Account account: accounts){
            if(account.getAccountNumber() == accountNumber){
                return account;
            }
        }
        return null;
    }
    public boolean deposit(int accountNumber,double amount){
        Account account = this.getAccount(accountNumber);
        if (account == null){
            return false;
        }

        if(amount > 0){
            account.deposit(amount);
            return true;
        }
        return false;
    }
    public  boolean withdraw(int accountNumber, double amount){
        Account account = this.getAccount(accountNumber);

        if(account == null){
            return false;

        }
        if(amount <= 0 || account.getBalance() < amount){
            return false;
        }
        account.withdraw(amount);
        return  true;
    }

    public static int getNextAccountNumber(){
        accountCounter++;
        return accountCounter;
    }
    public static double getFee(){
        return CHARGES;
    }
    public static  double getInterestRate(){
        return IR;
    }

}

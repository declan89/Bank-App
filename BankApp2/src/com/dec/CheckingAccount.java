package com.dec;

public class CheckingAccount extends Account {

    private static  double CHARGES = 1.0;

    public CheckingAccount(){
        super();
    }

    public CheckingAccount(int accountNumber,double charges){
        super(accountNumber);
        CHARGES = charges;
    }

    //Function to deposit funds into the account
    public void deposit(double amount) {

        // First Check amount
        if( amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);

            //  Transaction charges
            balance -= CHARGES;
            System.out.printf("charge %.2f Applied%n", CHARGES);
            System.out.printf("Current Balance is: %.2f%n", balance);

        } else {
            System.out.println("A negative amount cannot be deposited");
        }
    }


    // Function to withdraw funds from the Account
    public void withdraw(double amount) {


        if(amount > 0) {
            // Check sufficient balance
            if((amount+CHARGES) <= balance) {

                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                balance -= CHARGES;
                System.out.printf("charge of %.2f applied%n", CHARGES);
                System.out.printf("Current Balance is: %.2f%n", balance);
            }
        } else {
            System.out.println("Negative amount cannot be withdrawn!");
        }
    }
}











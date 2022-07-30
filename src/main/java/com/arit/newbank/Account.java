package com.arit.newbank;

import java.util.Scanner;
        
public class Account {
    int balance;
    int prevTransaction;
    String memberID;
    String memberName;
    
    Account(String mname, String mid) {
        memberName = mname;
        memberID = mid;
    }
    
    void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            prevTransaction = amount;
        }
    }
    
    void withdraw(int amount) {
        if (amount != 0) {
            balance -= amount;
            prevTransaction = -amount;
        }
    }
    
    void getPrevTransaction() {
        if (prevTransaction > 0) {
            System.out.println("Deposit: " + prevTransaction);
        } else if (prevTransaction < 0) {
            System.out.println("Withdrawl: " + Math.abs(prevTransaction));
        } else {
            System.out.println("No transactions to display");
        }
    }
    
    void getInterest(int years) {
        double interestRate = 0.0185;
        double updatedBalance = (balance * interestRate * years) + balance;
        System.out.println("Your annual interest rate is: " + (interestRate * 100) + "%");
        System.out.println("After " + years + " years, your total balance will be " + updatedBalance);
    }
    
    void showMenu() {
        char selection = '\0';
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Hello, " + memberName + "!");
        System.out.println("Your Member ID is: " + memberID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Review your balance");
        System.out.println("B. Deposit funds");
        System.out.println("C. Withdraw funds");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");
        
        do {
            System.out.println();
            System.out.println("Please make a selection: ");
            char userSelection = sc.next().charAt(0);
            selection = Character.toUpperCase(userSelection);
            System.out.println();
            
            switch(selection) {
                case 'A':
                    System.out.println("=====================");
                    System.out.println("Available Balance: $" + balance);
                    System.out.println("=====================");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("Enter amount to deposit: ");
                    int depositAmount = sc.nextInt();
                    deposit(depositAmount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("Enter amount to withdraw: ");
                    int withdrawAmount = sc.nextInt();
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("=====================");
                    getPrevTransaction();
                    System.out.println("=====================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("Enter number of years of accrued interest: ");
                    int years = sc.nextInt();
                    getInterest(years);
                    System.out.println();
                case 'F':
                    System.out.println("=====================");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        } while (selection != 'F');
        
        System.out.println("Thank you for being a valued member. Goodbye.");
        
    }
    
}

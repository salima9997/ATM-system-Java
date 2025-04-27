package org.example.Presentation;

import org.example.Services.IAccountService;

import java.util.Scanner;
import java.util.UUID;

public class PresentationConsole implements IPresentation {
    private IAccountService accountService;
    String username = null;
    Integer password = null;
    UUID accountId = null;

    public PresentationConsole(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void Execute(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while(choice!=6) {
            System.out.println("Choose action:");
            System.out.println("1. Create Account");
            System.out.println("2. View balance");
            System.out.println("3. Withdraw");
            System.out.println("4. Replenish");
            System.out.println("5. View history transactions");
            System.out.println("6. Exit");

            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter username:");
                    username = scanner.next();
                    System.out.println("Enter password:");
                    password = scanner.nextInt();
                    accountService.CreateAccount(username, password);
                    System.out.println("Account created");
                    accountId = accountService.GetAccountId(username);
                    break;

                case 2:
                    if (username==null){
                        Login(scanner);
                    }
                    System.out.println(accountService.ShowBalance(accountId));
                    break;

                case 3:
                    if (username==null){
                        Login(scanner);
                    }
                    System.out.println("Enter amount: ");
                    int amount = scanner.nextInt();
                    accountService.Withdrawal(accountId, amount);
                    break;

                case 4:
                    if (username==null){
                        Login(scanner);
                    }
                    System.out.println("Enter amount: ");
                    int amount2 = scanner.nextInt();
                    accountService.Replenishment(accountId, amount2);
                    break;

                case 5:
                    if (username==null){
                        Login(scanner);
                    }
                    for (String transaction : accountService.ShowHistory(accountId)){
                        System.out.println(transaction);
                    }
                    break;

                case 6:
                    break;

                default:
                    throw new IllegalArgumentException("Invalid choice");
            }
        }
    }

    private void Login(Scanner scanner){
        System.out.println("Enter username:");
        username = scanner.next();
        System.out.println("Enter password:");
        password = scanner.nextInt();
        accountService.CheckPassword(username, password);
        accountId = accountService.GetAccountId(username);
    }
}
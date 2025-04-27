package org.example;

import org.example.Presentation.IPresentation;
import org.example.Presentation.PresentationConsole;
import org.example.Repositories.Abstractions.IAccountBalanceRepository;
import org.example.Repositories.Abstractions.IAccountRepository;
import org.example.Repositories.Abstractions.ITransactionRepository;
import org.example.Repositories.Abstractions.IUserRepository;
import org.example.Repositories.AccountBalanceRepository;
import org.example.Repositories.AccountRepository;
import org.example.Repositories.TransactionRepository;
import org.example.Repositories.UserRepository;
import org.example.Services.AccountService;
import org.example.Services.IAccountService;

public class App {
  public static void main(String[] args) {
    IAccountBalanceRepository accountBalanceRepository = new AccountBalanceRepository();
    IAccountRepository accountRepository = new AccountRepository();
    ITransactionRepository transactionRepository = new TransactionRepository();
    IUserRepository userRepository = new UserRepository();
    IAccountService accountService = new AccountService(userRepository, accountRepository, transactionRepository, accountBalanceRepository);
    IPresentation presentation = new PresentationConsole(accountService);
    presentation.Execute();
  }
}
package org.example;

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
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
  IAccountBalanceRepository accountBalanceRepository = new AccountBalanceRepository();
  IAccountRepository accountRepository = new AccountRepository();
  ITransactionRepository transactionRepository = new TransactionRepository();
  IUserRepository userRepository = new UserRepository();
  IAccountService accountService = new AccountService(userRepository, accountRepository, transactionRepository, accountBalanceRepository);

  @Test
  public void Withdrawal_BalanceInsufficient_ShouldThrowException() {
    accountService.CreateAccount("name",21345);
    UUID accountId = accountService.GetAccountId("name");
    accountService.Replenishment(accountId, 100);

    Exception exception = assertThrows(RuntimeException.class, () -> {
      accountService.Withdrawal(accountId,300);
    });

    assertEquals(exception.getMessage(),"Balance insufficient");
  }

  @Test
  public void Test(){
    accountService.CreateAccount("name",21345);

    Exception exception = assertThrows(RuntimeException.class, () -> {
      accountService.CheckPassword("name", 12345);
    });

    assertEquals(exception.getMessage(),"Username or password incorrect");
  }
}
package org.example.Services;

import org.example.Repositories.Abstractions.IAccountBalanceRepository;
import org.example.Repositories.Abstractions.IAccountRepository;
import org.example.Repositories.Abstractions.ITransactionRepository;
import org.example.Repositories.Abstractions.IUserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class AccountService implements IAccountService {
    private IUserRepository userRepository;
    private IAccountRepository accountRepository;
    private ITransactionRepository transactionRepository;
    private IAccountBalanceRepository accountBalanceRepository;

    public AccountService(IUserRepository userRepository, IAccountRepository accountRepository, ITransactionRepository transactionRepository, IAccountBalanceRepository accountBalanceRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.accountBalanceRepository = accountBalanceRepository;
    }

    public void CreateAccount(String username, Integer password) {
        UUID accountId = UUID.randomUUID();
        userRepository.AddAccount(username, password);
        accountRepository.AddAccount(accountId, username);
        accountBalanceRepository.AddAccountBalance(accountId);
    }
    public List<String> ShowHistory(UUID accountId) {
        return transactionRepository.ShowHistory(accountId);
    }
    public int ShowBalance(UUID accountId) {
        return accountBalanceRepository.GetBalance(accountId);
    }
    public void Replenishment(UUID accountId, int amount) {
        String transaction = LocalDateTime.now() + " replenishment " + amount;
        transactionRepository.AddTransaction(accountId, transaction);
        accountBalanceRepository.Replenishment(accountId, amount);
    }

    public void Withdrawal(UUID accountId, int amount) {
        if (!accountBalanceRepository.CheckBalance(accountId, amount)) {
            throw new RuntimeException("Balance insufficient");
        }
        String transaction = LocalDateTime.now() + " withdrawal " + amount;
        transactionRepository.AddTransaction(accountId, transaction);
        accountBalanceRepository.Withdrawal(accountId, amount);
    }

    public void CheckPassword(String username, Integer password) {
        if(!userRepository.CheckPassword(username, password)){
            throw new RuntimeException("Username or password incorrect");
        }
    }
    public UUID GetAccountId(String username) {
        return accountRepository.GetAccount(username);
    }

}
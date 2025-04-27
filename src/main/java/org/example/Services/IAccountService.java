package org.example.Services;

import java.util.List;
import java.util.UUID;

public interface IAccountService {
    void CreateAccount(String username, Integer password);
    List<String> ShowHistory(UUID accountId);
    int ShowBalance(UUID accountId);
    void Replenishment(UUID accountId, int amount);
    void Withdrawal(UUID accountId, int amount);
    void CheckPassword(String username, Integer password);
    UUID GetAccountId(String username);
}
package org.example.Repositories.Abstractions;

import java.util.UUID;

public interface IAccountBalanceRepository {
    int GetBalance(UUID accountId);
    void AddAccountBalance(UUID accountId);
    void Replenishment(UUID accountId, int amount);
    void Withdrawal(UUID accountId, int amount);
    boolean CheckBalance(UUID accountId, int amount);
}
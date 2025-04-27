package org.example.Repositories;

import org.example.Repositories.Abstractions.IAccountBalanceRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AccountBalanceRepository implements IAccountBalanceRepository {
    private Map<UUID,Integer> accountsBalance = new HashMap<>();
    public void AddAccountBalance(UUID accountId) {
        accountsBalance.put(accountId, 0);
    }
    public int GetBalance(UUID accountId) {
        return accountsBalance.get(accountId);
    }
    public void Replenishment(UUID accountId, int amount) {
        Integer newBalance = accountsBalance.get(accountId) + amount;
        accountsBalance.remove(accountId);
        accountsBalance.put(accountId, newBalance);
    }
    public void Withdrawal(UUID accountId, int amount) {
        Integer newBalance = accountsBalance.get(accountId) - amount;
        accountsBalance.remove(accountId);
        accountsBalance.put(accountId, newBalance);
    }
    public boolean CheckBalance(UUID accountId, int amount) {
        return accountsBalance.get(accountId) > amount;
    }
}
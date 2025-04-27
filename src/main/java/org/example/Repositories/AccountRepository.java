package org.example.Repositories;

import org.example.Repositories.Abstractions.IAccountRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AccountRepository implements IAccountRepository {
    private Map<String, UUID> accounts = new HashMap<>();
    public void AddAccount(UUID accountId, String username) {
        accounts.put(username, accountId);
    }
    public UUID GetAccount(String username) {
        return accounts.get(username);
    }
}
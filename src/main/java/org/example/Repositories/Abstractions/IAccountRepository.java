package org.example.Repositories.Abstractions;

import java.util.UUID;

public interface IAccountRepository {
    void AddAccount(UUID accountId, String username);
    UUID GetAccount(String username);
}
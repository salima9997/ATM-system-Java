package org.example.Repositories.Abstractions;

import java.util.List;
import java.util.UUID;

public interface ITransactionRepository {
    void AddTransaction(UUID accountId, String transaction);
    List<String> ShowHistory(UUID accountId);
}
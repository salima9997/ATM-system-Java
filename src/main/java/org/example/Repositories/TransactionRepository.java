package org.example.Repositories;

import org.example.Repositories.Abstractions.ITransactionRepository;

import java.util.*;

public class TransactionRepository implements ITransactionRepository {
    private Map<UUID, List<String>> transactions = new HashMap<>();
    public void AddTransaction(UUID accountId, String transaction) {
        List<String> newTransactions = new ArrayList<>();
        if (transactions.get(accountId)!=null) {
            newTransactions = transactions.get(accountId);
        }
        newTransactions.add(transaction);
        transactions.remove(accountId);
        transactions.put(accountId, newTransactions);
    }
    public List<String> ShowHistory(UUID accountId) {
        return transactions.get(accountId);
    }
}
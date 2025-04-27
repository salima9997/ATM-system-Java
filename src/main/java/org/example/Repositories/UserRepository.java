package org.example.Repositories;

import org.example.Repositories.Abstractions.IUserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserRepository implements IUserRepository {
    private Map<String, Integer> users = new HashMap<>();
    public void AddAccount(String username, Integer password) {
        users.put(username, password);
    }
    public boolean CheckPassword(String username, Integer password) {
        return Objects.equals(users.get(username), password);
    }
}
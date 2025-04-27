package org.example.Repositories.Abstractions;

public interface IUserRepository {
    void AddAccount(String username, Integer password);
    boolean CheckPassword(String username, Integer password);
}
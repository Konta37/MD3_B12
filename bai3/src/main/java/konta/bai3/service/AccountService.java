package konta.bai3.service;

import konta.bai3.entity.Account;

import java.util.List;

public interface AccountService {
    public List<Account> findAll();
    public Account findById(Integer id);
    public boolean add(Account account);
    public boolean edit(Account account);
    public boolean delete(Integer id);
    public List<Account> findByUserName(String name);
}

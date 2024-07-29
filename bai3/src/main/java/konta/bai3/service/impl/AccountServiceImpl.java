package konta.bai3.service.impl;

import konta.bai3.dao.impl.AccountDAOImpl;
import konta.bai3.entity.Account;
import konta.bai3.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    @Override
    public List<Account> findAll() {
        return new AccountDAOImpl().findAll();
    }

    @Override
    public Account findById(Integer id) {
        return new AccountDAOImpl().findById(id);
    }

    @Override
    public boolean add(Account account) {
        return new AccountDAOImpl().add(account);
    }

    @Override
    public boolean edit(Account account) {
        return new AccountDAOImpl().edit(account);
    }

    @Override
    public boolean delete(Integer id) {
        return new AccountDAOImpl().delete(id);
    }

    @Override
    public List<Account> findByUserName(String name) {
        return new AccountDAOImpl().findByUserName(name);
    }
}

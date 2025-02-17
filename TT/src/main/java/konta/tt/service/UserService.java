package konta.tt.service;

import konta.tt.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findById(Integer id);
    public boolean add(User user);
    public boolean edit(User user);
    public boolean delete(Integer id);
    public List<User> findByName(String name);
}

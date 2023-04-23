package com.store.backend.service;

import com.store.backend.model.User;
import com.store.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public User addUser(User user) {
        user.setId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(user);
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public User getUserById(String id) {
        return repository.findById(id).get();
    }

    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).get();
        existingUser.setEmail(user.getEmail());
        existingUser.setName(user.getName());
        existingUser.setSurname(user.getSurname());

        return repository.save(existingUser);
    }

    public String deleteUser(String id) {
        repository.deleteById(id);
        return "User " + id + " deleted!";
    }
}

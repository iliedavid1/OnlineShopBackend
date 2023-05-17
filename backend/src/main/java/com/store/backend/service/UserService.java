package com.store.backend.service;

import com.store.backend.model.User;
import com.store.backend.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    public static final String pk = "qsdfghjiuyuaw";

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

    public Boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    public Cookie genUserSessionCookie(User user) throws NoSuchAlgorithmException {
        String userid = user.getId();

        String signature = Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-256")
                .digest((userid + pk).getBytes(StandardCharsets.UTF_8)));

        String payload = Base64.getEncoder().encodeToString((userid + "@" + signature)
                .getBytes(StandardCharsets.UTF_8));

        return new Cookie("shopIPSessionID", payload);

    }

    public User retrieveLoggedUser(String cookieValue) {
        try {
            String payload = new String(Base64.getDecoder().decode(cookieValue), StandardCharsets.UTF_8);
            String userid = payload.split("@")[0];
            String signature = null;
            signature = Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-256")
                    .digest((userid + pk).getBytes(StandardCharsets.UTF_8)));
            if (signature.equals(payload.split("@")[1])) {
                return getUserById(userid);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}

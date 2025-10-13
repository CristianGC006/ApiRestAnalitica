package com.example.APIAnalityc.services;

import com.example.APIAnalityc.models.User;
import com.example.APIAnalityc.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    IUserRepository repository;

    public User saveUser(User user) throws Exception {
        try {
            return repository.save(user);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public User getUserById(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Usuario no encontrado"));
    }

    public java.util.List<User> getAllUsers() {
        return repository.findAll();
    }

    public User updateUser(Integer id, User userDetails) throws Exception {
        User user = repository.findById(id).orElseThrow(() -> new Exception("Usuario no encontrado"));
        user.setName(userDetails.getName());
        user.setPassword(userDetails.getPassword());
        user.setDateOfBirth(userDetails.getDateOfBirth());
        return repository.save(user);
    }

    public void deleteUser(Integer id) throws Exception {
        User user = repository.findById(id).orElseThrow(() -> new Exception("Usuario no encontrado"));
        repository.delete(user);
    }
}

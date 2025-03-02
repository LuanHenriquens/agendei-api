package com.agendei.agendei_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendei.agendei_api.model.User;
import com.agendei.agendei_api.repository.UserRepository;

import java.util.Optional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    public Optional<User> findUserByName(String name) {
        return userRepository.findByName(name);
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> updateUser(Integer id, User userDetails) {
        Optional<User> exintingUser = userRepository.findById(id);

        if (exintingUser.isPresent()) {
            User user = exintingUser.get();
            
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setPhone(userDetails.getPhone());
            user.setActive(userDetails.getActive());
            user = userRepository.save(user);

            return Optional.of(user);
        }

        return Optional.empty();
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public boolean isIdTaken(Integer id) {
        return userRepository.existsById(id);
    }
}

package com.example.techtestapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserRepositoryDynamicQueries userRepositoryDynamicQueries;

    @Autowired
    public UserService(UserRepository userRepository, UserRepositoryDynamicQueries userRepositoryDynamicQueries) {
        this.userRepository = userRepository;
        this.userRepositoryDynamicQueries = userRepositoryDynamicQueries;
    }

    public List<User> getUsers(Optional<String> name, Optional<Boolean> active) {
        return this.userRepositoryDynamicQueries.findUserWithQuery(name, active);
    }

    public User createUser(User user) {
        Optional<User> userByDocument = userRepository.findByDocument(user.getDocument());

        if(userByDocument.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Document taken");
        }

        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(User user, int id) {
        Optional<User> found = userRepository.findById(id);

        if(found.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User do not exists");
        }

        User toEdit = found.get();
        toEdit.setName(user.getName());
        toEdit.setDocument(user.getDocument());
        toEdit.setRegistry(user.getRegistry());
        toEdit.setPhone(user.getPhone());
        toEdit.setType(user.getType());
        toEdit.setActive(user.getActive());
        toEdit.setBirthday(user.getBirthday());

        return toEdit;
    }

    public void deleteUser(int id) {
        boolean exists = userRepository.existsById(id);
        if(!exists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User do not exists");
        }

        userRepository.deleteById(id);
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }
}

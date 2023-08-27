package com.example.techtestapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public User createUser(User user) {
        Optional<User> userByDocument = userRepository.findUserByDocument(user.getDocument());

        if(userByDocument.isPresent()) {
            throw new IllegalStateException("Document allready exitsts");
        }

        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(User user, int id) {
        Optional<User> found = userRepository.findById(id);

        if(found.isEmpty()) {
            throw new IllegalStateException("User do not exist");
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
            throw new IllegalStateException("User do not exist");
        }

        userRepository.deleteById(id);
    }
}

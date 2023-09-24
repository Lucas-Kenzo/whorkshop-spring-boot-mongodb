package com.kenzo.workshopmongo.user.service;

import com.kenzo.workshopmongo.user.model.User;
import com.kenzo.workshopmongo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}

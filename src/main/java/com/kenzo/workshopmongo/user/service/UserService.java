package com.kenzo.workshopmongo.user.service;

import com.kenzo.workshopmongo.comum.exception.service.ObjectNotFoundException;
import com.kenzo.workshopmongo.user.model.User;
import com.kenzo.workshopmongo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user =  repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public User insert(User obj){
        return repository.insert(obj);
    }

}

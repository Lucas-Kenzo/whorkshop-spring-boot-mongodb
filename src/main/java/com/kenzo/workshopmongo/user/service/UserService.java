package com.kenzo.workshopmongo.user.service;

import com.kenzo.workshopmongo.comum.exception.service.ObjectNotFoundException;
import com.kenzo.workshopmongo.user.model.User;
import com.kenzo.workshopmongo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ObjectStreamException;
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

    public User edit(User obj){
        User newObj = findById(obj.getId());
        cpfExistente(obj);
        updateDate(newObj, obj);
        return repository.save(newObj);
    }

    private void updateDate(User newObj, User obj) {

        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User insert(User obj){
        cpfExistente(obj);
        return repository.insert(obj);
    }

    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public void cpfExistente(User obj){
        repository.findByCpf(obj.getCpf()).ifPresent(
                user -> {
                    if (!user.getId().equals(obj.getId())) {
                        throw new ObjectNotFoundException("Cpf ja existente");
                    }
                }
        );
    }
}

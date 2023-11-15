package com.kenzo.workshopmongo.user.controller;

import com.kenzo.workshopmongo.user.dto.UserDTO;
import com.kenzo.workshopmongo.user.model.User;
import com.kenzo.workshopmongo.user.service.UserService;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        var users = service.findAll();
        var usersDto = users.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(usersDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        var user = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody User obj){
        var user  = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}

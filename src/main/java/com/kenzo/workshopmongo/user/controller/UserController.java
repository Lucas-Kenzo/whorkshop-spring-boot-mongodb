package com.kenzo.workshopmongo.user.controller;

import com.kenzo.workshopmongo.user.dto.UserDTO;
import com.kenzo.workshopmongo.user.model.User;
import com.kenzo.workshopmongo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

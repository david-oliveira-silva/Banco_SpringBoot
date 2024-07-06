package com.exemple.transferencia.Controller;

import com.exemple.transferencia.DTO.UserDTO;
import com.exemple.transferencia.Entity.User;
import com.exemple.transferencia.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/registrar")
    public ResponseEntity<User> newUser(@RequestBody @Valid  UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.CriarUsuario(userDTO));
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>>getUser(){
     return ResponseEntity.status(HttpStatus.OK).body(userService.getUser());

    }
}

package com.exemple.transferencia.Service;


import com.exemple.transferencia.DTO.UserDTO;
import com.exemple.transferencia.Entity.Enum.UserType;
import com.exemple.transferencia.Entity.User;
import com.exemple.transferencia.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void validarTransferencia(User pagador,BigDecimal valor) throws Exception {
        if (pagador.getUserType() == UserType.LOGISTA){
            throw  new Exception("Logista não pode fazer Transferencia");
        }
        if (pagador.getBalanco().compareTo(valor) < 0){
            throw new Exception("Saldo insuficiente");
        }

    }
    public User CriarUsuario(UserDTO userDTO){
        var newUser = new User();
        BeanUtils.copyProperties(userDTO,newUser);
        userRepository.save(newUser);
        return newUser;
    }
    public void saveUser(User user){
        userRepository.save(user);

    }
    public User findByUser(Long id){
     return userRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));

    }
    public List<User> getUser(){
        return userRepository.findAll();
    }

}

package com.exemple.transferencia.Controller;

import com.exemple.transferencia.DTO.TransferenciaDTO;
import com.exemple.transferencia.Entity.Transferencia;
import com.exemple.transferencia.Service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class TransferenciaController {
    @Autowired
    TransferenciaService transferenciaService;
    @PostMapping("/transferir")
    public ResponseEntity<Transferencia> transferir(@RequestBody  TransferenciaDTO transferenciaDTO) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.Transferencia(transferenciaDTO));

    }
}

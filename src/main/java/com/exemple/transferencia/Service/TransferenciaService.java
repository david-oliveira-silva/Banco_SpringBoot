package com.exemple.transferencia.Service;

import com.exemple.transferencia.DTO.TransferenciaDTO;
import com.exemple.transferencia.Entity.Transferencia;
import com.exemple.transferencia.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaService {

    @Autowired
    UserService userService;

    public Transferencia Transferencia(TransferenciaDTO transfereciaDTO) throws Exception {
        User pagador = userService.findByUser(transfereciaDTO.pagador_id());
        User receber = userService.findByUser(transfereciaDTO.receber_id());
        userService.validarTransferencia(pagador,transfereciaDTO.valor());

        var newtransferencia = new Transferencia();
        newtransferencia.setValor(transfereciaDTO.valor());
        newtransferencia.setPagador(pagador);
        newtransferencia.setReceber(receber);

        pagador.setBalanco(pagador.getBalanco().subtract(transfereciaDTO.valor()));
        receber.setBalanco(receber.getBalanco().add(transfereciaDTO.valor()));
        this.userService.saveUser(pagador);
        this.userService.saveUser(receber);
        return newtransferencia;
    }
}

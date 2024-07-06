package com.exemple.transferencia.DTO;

import java.math.BigDecimal;

public record TransferenciaDTO(
        BigDecimal valor,
        Long pagador_id,
        Long receber_id
){

}

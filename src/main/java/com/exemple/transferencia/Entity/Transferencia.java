package com.exemple.transferencia.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "transferencia")
@Table(name = "transferecia")
@AllArgsConstructor
@NoArgsConstructor
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "pagador_id")
    private User pagador;
    @ManyToOne
    @JoinColumn(name = "receber_id")
    private User receber;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public User getPagador() {
        return pagador;
    }

    public void setPagador(User pagador) {
        this.pagador = pagador;
    }

    public User getReceber() {
        return receber;
    }

    public void setReceber(User receber) {
        this.receber = receber;
    }
}

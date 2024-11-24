package com.miapp;

import jakarta.persistence.*;

@Entity
public class Pedido{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num_pedido;

    private int importe;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    public Pedido(){}

    public Pedido(int importe, Cliente cliente){
        this.importe = importe;
        this.cliente = cliente;
    }

    public Long getNum_pedido(){
        return num_pedido;
    }
    public int getImporte(){
        return importe;
    }
    public Cliente getCliente(){
        return cliente;
    }

    public void setNum_pedido(Long num_pedido){
        this.num_pedido = num_pedido;
    }
    public void setImporte(int importe){
        this.importe = importe;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
}
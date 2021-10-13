/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.time.LocalDate;

/**
 *
 * @author Matheus
 */
public class Objetivos {
    private int idObjetivo;
    private String meta, cpf;
    private double preco, caixa, aporte_mensal;// Aporte é o valor que o usuário irá separar todos os meses
    private LocalDate data_estimada, data_adicionar_no_caixa;
    boolean adicionar_no_caixa; //se o usuario liberar, o programa vai verificar a data de adicioar e colocar mais o valor que ele disse mensalmente;

    public Objetivos(int idObjetivo, String meta, String cpf, double preco, double caixa, double aporte_mensal, LocalDate data_estimada, LocalDate data_adicionar_no_caixa, boolean adicionar_no_caixa) {
        this.idObjetivo = idObjetivo;
        this.meta = meta;
        this.cpf = cpf;
        this.preco = preco;
        this.caixa = caixa;
        this.aporte_mensal = aporte_mensal;
        this.data_estimada = data_estimada;
        this.data_adicionar_no_caixa = data_adicionar_no_caixa;
        this.adicionar_no_caixa = adicionar_no_caixa;
    }

    public int getIdObjetivo() {
        return idObjetivo;
    }

    public String getMeta() {
        return meta;
    }
    public String getCpf() {
        return cpf;
    }
    public double getPreco() {
        return preco;
    }
    public double getCaixa() {
        return caixa;
    }
    public double getAporte_mensal() {
        return aporte_mensal;
    }
    public LocalDate getData_estimada() {
        return data_estimada;
    }
    public LocalDate getData_adicionar_no_caixa() {
        return data_adicionar_no_caixa;
    }
    public boolean isAdicionar_no_caixa() {
        return adicionar_no_caixa;
    }

    
    public void setIdObjetivo(int idObjetivo) {
        this.idObjetivo = idObjetivo;
    }
    public void setMeta(String meta) {
        this.meta = meta;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setCaixa(double caixa) {
        this.caixa = caixa;
    }
    public void setAporte_mensal(double aporte_mensal) {
        this.aporte_mensal = aporte_mensal;
    }
    public void setData_estimada(LocalDate data_estimada) {
        this.data_estimada = data_estimada;
    }
    public void setData_adicionar_no_caixa(LocalDate data_adicionar_no_caixa) {
        this.data_adicionar_no_caixa = data_adicionar_no_caixa;
    }
    public void setAdicionar_no_caixa(boolean adicionar_no_caixa) {
        this.adicionar_no_caixa = adicionar_no_caixa;
    }


    
    
}

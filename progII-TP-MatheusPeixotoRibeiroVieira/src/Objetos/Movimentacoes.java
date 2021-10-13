/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Matheus
 */
public class Movimentacoes {
    private String CPF, motivo;
    private int numero_movimentacao, idobjetivo;
    private double valor;
    private LocalDate data;
    private LocalTime hora;
    private boolean recebeu;

        
    
    public Movimentacoes(String CPF, String motivo, int numero_movimentacao, double valor, LocalDate data, LocalTime hora, boolean recebeu, int idobjetivo) {
        this.CPF = CPF;
        this.motivo = motivo;
        this.numero_movimentacao = numero_movimentacao;
        this.valor = valor;
        this.data = data;
        this.hora = hora;
        this.recebeu = recebeu;
        this.idobjetivo = idobjetivo;
    }
    
    public String getCPF() {
        return CPF;
    }
    public String getMotivo() {
        return motivo;
    }
    public int getNumero_movimentacao() {
        return numero_movimentacao;
    }
    public double getValor() {
        return valor;
    }
    public LocalDate getData() {
        return data;
    }
    public LocalTime getHora() {
        return hora;
    }
    public boolean isRecebeu() {
        return recebeu;
    }
    public int getIdobjetivo(){
        return this.idobjetivo;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public void setNumero_movimentacao(int numero_movimentacao) {
        this.numero_movimentacao = numero_movimentacao;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public void setRecebeu(boolean recebeu) {
        this.recebeu = recebeu;
    }
    public void setIdobjetivo(int idobjetivo){
        this.idobjetivo = idobjetivo;
    }
    
    public boolean equals(Object o){
        Movimentacoes outra = (Movimentacoes) o;
        if(this.numero_movimentacao == outra.getNumero_movimentacao()){
            return true;
        }
        return false;
    }
    
    
}

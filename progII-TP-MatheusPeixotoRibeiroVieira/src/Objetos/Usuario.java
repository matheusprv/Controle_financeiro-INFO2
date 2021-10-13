/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Matheus
 */
public class Usuario {
    private String nome,sobrenome,cpf,email,senha;
    private double saldo;

    public Usuario(String nome, String sobrenome, String cpf, String email, String senha, double saldo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public double getSaldo() {
        return saldo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setSaldo(double saldo) {
        this.saldo += saldo;
    }
    public void setSaldoManual(double saldo){//Usado na página de configurações de usuário
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha + ", saldo=" + saldo + '}';
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.programa.model;

/**
 *
 * @author samuc
 */
public class Funcionarios {
    
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String nivel_acesso;
    private String cc_recebimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    public String getCc_recebimento() {
        return cc_recebimento;
    }

    public void setCc_recebimento(String cc_recebimento) {
        this.cc_recebimento = cc_recebimento;
    }
    
    
    
}

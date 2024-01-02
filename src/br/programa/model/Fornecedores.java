/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.programa.model;

/**
 *
 * @author samuc
 */
public class Fornecedores {
    
    
    private int id;
    private String Razao;
    private String Cnpj;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazao() {
        return Razao;
    }

    public void setRazao(String Razao) {
        this.Razao = Razao;
    }

    public String getCnpj() {
        return Cnpj;
    }

    public void setCnpj(String Cnpj) {
        this.Cnpj = Cnpj;
    }
    
    @Override
    public String toString(){
        
        return this.getRazao();
        
    }
    
}

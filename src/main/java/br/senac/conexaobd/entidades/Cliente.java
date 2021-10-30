/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.conexaobd.entidades;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Tiago Scarton
 */
@Getter
@Setter
public class Cliente {

    private String nome;
    private String email;
    private String cpf;  

    @Override
    public String toString() {
        return "nome=" + nome + ", email=" + email + ", cpf=" + cpf;
    }
    
    
    
}

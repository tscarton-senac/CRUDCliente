/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author tscarton
 */
@Getter
@Setter
public class Usuario {
    
    private String nome;
    private String login;
    private String senha;
    private String perfil;
    
    public String codificarSenha(String senha) {
        return BCrypt.withDefaults().hashToString(12, senha.toCharArray());
    }
    
    public boolean validarSenha(String senha) {
        BCrypt.Result response = BCrypt.verifyer().verify(senha.toCharArray(), this.senha);
        return response.verified;
    }
    
    public boolean isAdmin() {
        return this.perfil.equalsIgnoreCase("admin");
    }
    
}

package br.senac.conexaobd.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private int id;
    private String nome;
    private String usuario;
    private String senha;
    private String perfil;
    
    public boolean isAdmin(){
        return "admin".equalsIgnoreCase(this.perfil);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import br.senac.sp.bd.ConexaoDB;
import br.senac.sp.entidade.Cliente;
import br.senac.sp.entidade.Usuario;
import br.senac.sp.servlet.ServletBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tscarton
 */
public class UsuarioDAO {
    
    public static Usuario getUsuario(String login) {
        Usuario usuario = null;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from usuario where login=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String perfil = rs.getString("perfil");
                String senha = rs.getString("senha");
                usuario = new Usuario();
                usuario.setNome(nome);
                usuario.setPerfil(perfil);
                usuario.setLogin(login);
                usuario.setSenha(senha);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
}

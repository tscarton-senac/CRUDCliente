
package br.senac.conexaobd.dao;

import br.senac.conexaobd.Conexao;
import br.senac.conexaobd.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAO {
    
    public static Usuario getUsuario(String login) {
        Connection con = Conexao.getConexao();
        Usuario usuario = null;
        String query = "select * from usuario where usuario=?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String perfil = rs.getString("perfil");
                String senhaFechada = rs.getString("senha");
                usuario = new Usuario();
                usuario.setId(id);
                usuario.setNome(nome);
                usuario.setPerfil(perfil);
                usuario.setUsuario(login);
                usuario.setSenha(senhaFechada);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return usuario;
    }
    
}

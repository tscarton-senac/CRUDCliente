/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.conexaobd.dao;

import br.senac.conexaobd.Conexao;
import br.senac.conexaobd.entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiago Scarton
 */
public class ClienteDAO {
    
    public static void inserirCliente(Cliente cliente) throws SQLException {
        boolean ok = true;
        String query = "insert into cliente(nome,cpf,email) values (?,?,?)";
        Connection con = Conexao.getConexao();
        PreparedStatement ps;
        ps = con.prepareStatement(query);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getEmail());
        ps.execute();

    }

   public static List<Cliente> getClientes() {
       List<Cliente> clientes = new ArrayList<>();
       String query = "select * from cliente";
       
       Connection con = Conexao.getConexao();
       try {
           PreparedStatement ps = con.prepareStatement(query);
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {
               Cliente cliente = new Cliente();
               String nome = rs.getString("nome");
               String email = rs.getString("email");
               String cpf = rs.getString("cpf");
               cliente.setNome(nome);
               cliente.setEmail(email);
               cliente.setCpf(cpf);
               clientes.add(cliente);
           }
       } catch (SQLException ex) {
           Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
       return clientes;
       
   }
   
   public static Cliente getClientePorCPF(String cpf) {
       Cliente cliente = null;
       String query = "select * from cliente where cpf=?";
       
       Connection con = Conexao.getConexao();
       try {
           PreparedStatement ps = con.prepareStatement(query);
           ps.setString(1, cpf);
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {
               cliente = new Cliente();
               String nome = rs.getString("nome");
               String email = rs.getString("email");
               cliente.setNome(nome);
               cliente.setEmail(email);
               cliente.setCpf(cpf);
           }
       } catch (SQLException ex) {
           Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
       return cliente;
       
   }
   
   public static List<Cliente> getClientePorNome(String nomeParam) {
       nomeParam = nomeParam.toUpperCase();
       List<Cliente> clientes = new ArrayList<>();
       String query = "select * from cliente where UPPER(nome) like ?";
       
       Connection con = Conexao.getConexao(); 
       try {
           PreparedStatement ps = con.prepareStatement(query);
           ps.setString(1, nomeParam+"%");
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {
               Cliente cliente = new Cliente();
               String nome = rs.getString("nome");
               String email = rs.getString("email");
               String cpf = rs.getString("cpf");
               cliente.setNome(nome);
               cliente.setEmail(email);
               cliente.setCpf(cpf);
               clientes.add(cliente);
           }
       } catch (SQLException ex) {
           Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
       return clientes;
       
   }
   
   public static boolean deletarCliente(String cpf) {
       boolean ok = true;
       String query = "delete from cliente where cpf=?";
       Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
   }
   
   public static boolean atualizarCliente(Cliente cliente) {
       boolean ok = true;
       String query = "update cliente set nome=?,email=? where cpf=?";
       Connection con = Conexao.getConexao();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getCpf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
   }
   

}

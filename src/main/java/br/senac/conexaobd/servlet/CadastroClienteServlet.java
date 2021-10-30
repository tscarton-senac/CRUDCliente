/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.conexaobd.servlet;

import br.senac.conexaobd.dao.ClienteDAO;
import br.senac.conexaobd.entidades.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tiago.bscarton
 */
public class CadastroClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ope = request.getParameter("ope");
         // Passo 1 - Recuperar os parametros
        String nome = request.getParameter("nomeCliente");
        String email = request.getParameter("emailCliente");
        String cpf = request.getParameter("cpfCliente");

        // Passo 2 - Inserir no BD
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        try {
            // ope = 1 => Update
            if ("1".equals(ope)) {
               ClienteDAO.atualizarCliente(cliente);
            } else {
               ClienteDAO.inserirCliente(cliente);
            }
            response.sendRedirect(request.getContextPath()+"/uteis/sucesso.jsp");
        } catch(SQLException ex) {
           response.sendRedirect(request.getContextPath()+"/uteis/erro.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cpf = req.getParameter("cpfUsuario");
        String ope = req.getParameter("ope");
        //OPE = 1 => Atualização
        if ("1".equals(ope)) {
            Cliente cliente = ClienteDAO.getClientePorCPF(cpf);
            req.setAttribute("clienteAtualizacao", cliente);
            req.getRequestDispatcher("/cliente/cadastro.jsp").forward(req, resp);
        } else {
            ClienteDAO.deletarCliente(cpf);
            resp.sendRedirect(req.getContextPath() + "/cliente/ListarClienteServlet");
        }
        
        
    }
    
    

    

}

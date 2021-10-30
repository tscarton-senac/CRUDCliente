/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.conexaobd.servlet;

import br.senac.conexaobd.dao.ClienteDAO;
import br.senac.conexaobd.entidades.Cliente;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tiago.bscarton
 */
public class BuscaCliente extends HttpServlet {

   
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String nomeCliente = request.getParameter("nomeCliente");
       List<Cliente> clientes = ClienteDAO.getClientePorNome(nomeCliente);
       String clientesJson = new Gson().toJson(clientes );
       response.setContentType("text/html");
       PrintWriter pw = response.getWriter();
       pw.write(clientesJson);
    }

    
}

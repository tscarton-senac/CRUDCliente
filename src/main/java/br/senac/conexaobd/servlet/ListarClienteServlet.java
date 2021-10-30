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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tiago.bscarton
 */
public class ListarClienteServlet extends HttpServlet {

    

      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Cliente> clientes = ClienteDAO.getClientes();
        request.setAttribute("listaClientes", clientes);
        
        // RequestDispatcher reaproveita os objetos Request e Response
        String url = "/cliente/listar.jsp";
        request.getRequestDispatcher(url).forward(request, response);
        
        //sendRedirect sempre cria um novo request/response
        //response.sendRedirect("listar.jsp");
    }

   

}

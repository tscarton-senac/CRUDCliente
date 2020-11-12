/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ClienteDAO;
import br.senac.sp.entidade.Cliente;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tscarton
 */
public class CarrinhoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = request.getParameter("cpf");

        Cliente cliente = ClienteDAO.getCliente(Long.parseLong(cpf));

        HttpSession sessao = request.getSession();
        List<Cliente> listaClientes;
        if (sessao.getAttribute("listaClientes") == null) {
            listaClientes = new ArrayList<>();
        } else {
            listaClientes = (List<Cliente>) sessao.getAttribute("listaClientes");
        }
        if (!listaClientes.contains(cliente)) {
            listaClientes.add(cliente);
        }
        
        sessao.setAttribute("listaClientes", listaClientes);
    }

}

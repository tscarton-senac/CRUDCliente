/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.conexaobd.servlet;

import br.senac.conexaobd.dao.UsuarioDAO;
import br.senac.conexaobd.entidades.Usuario;
import br.senac.conexaobd.uteis.CryptoUtils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tiago.bscarton
 */
public class LoginServlet extends HttpServlet {

    // Logout
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        sessao.invalidate();
        response.sendRedirect(request.getContextPath()+"/login.jsp");
        
    }

    // Login
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String nomeUsuario = request.getParameter("nomeUsuario");
       String senhaUsuario = request.getParameter("senhaUsuario");
       
        Usuario usuario = UsuarioDAO.getUsuario(nomeUsuario);
        if (usuario == null) {
            response.sendRedirect(request.getContextPath()+"/login.jsp?loginInvalido=true");
        } else {
            boolean senhaOK = CryptoUtils.verificarSenha(senhaUsuario, usuario.getSenha());
            if (senhaOK) {
                HttpSession sessao = request.getSession();
                sessao.setAttribute("usuario", usuario);
                response.sendRedirect(request.getContextPath()+"/protegido/index.jsp");
            } else {
                response.sendRedirect(request.getContextPath()+"/login.jsp?loginInvalido=true");
            }
        }
    }

}

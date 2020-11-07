/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.UsuarioDAO;
import br.senac.sp.entidade.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tscarton
 */
public class LoginServlet extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Usuario usuario = UsuarioDAO.getUsuario(login);
        if (usuario != null && usuario.validarSenha(senha)) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario);
            response.sendRedirect(request.getContextPath()+"/protegido/index.jsp");
        } else {
            response.sendRedirect(request.getContextPath()+"/login.jsp?erro=userNotFound");
        }
        
    }


}

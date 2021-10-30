<%-- 
    Document   : cadastro
    Created on : 17/09/2021, 21:00:14
    Author     : tiago.bscarton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Clientes</title>
    </head>
    <body class="container">
        <c:import url="../../uteis/header.jsp"/>
        <h1>Formulário de Clientes</h1>
        <form action="CadastroClienteServlet" method="POST">
            <c:if test="${not empty clienteAtualizacao}">
                <input type="hidden" name="ope" value="1"/>
            </c:if>
            <div  class="form-group">
                <label>Nome</label>
                <input type="text" name="nomeCliente" value="${clienteAtualizacao.nome}"
                       required class="form-control"/><br/> 
            </div>
            <div class="form-group">
                <label>Email</label>
                <input type="text" name="emailCliente" value="${clienteAtualizacao.email}"
                       required class="form-control"/><br/>
            </div>
            <div class="form-group">
                <label>CPF</label>
                <c:if test="${empty clienteAtualizacao}">
                    <input type="text" name="cpfCliente"
                           value="${clienteAtualizacao.cpf}" 
                           required
                           class="form-control"
                           />
                </c:if>
                <c:if test="${not empty clienteAtualizacao}">
                    <label>${clienteAtualizacao.cpf}</label>
                    <input type="hidden" name="cpfCliente"
                           value="${clienteAtualizacao.cpf}" 
                           required
                           class="form-control"
                           />
                </c:if>           

            </div>
            <br/>


            <br/>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </body>
</html>

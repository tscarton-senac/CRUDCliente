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
        <title>Listar de Clientes</title>
    </head>
    <body class="container">
        <c:import url="../../uteis/header.jsp"/>
        
        <input type="text" id="nomeCliente" class="form-control"/><br/>
        <button onclick="buscar()" class="btn btn-primary">Buscar</button>
        
        <div id="msgAlerta" class="alert alert-warning" role="alert" style="display:none">
            <span id="txtAlerta"></span>
        </div>
        
        <table id="tabelaClientes" class="table">
            <thead>
                <th>Nome</th>
                <th>Email</th>
                <th>CPF</th>
            </thead>
            <tbody>
                
            </tbody>
        </table>

</body>
<a href="${pageContext.request.contextPath}/index.jsp">Voltar</a>
</html>

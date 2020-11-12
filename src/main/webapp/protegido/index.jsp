<%-- 
    Document   : index
    Created on : Sep 25, 2020, 9:09:13 PM
    Author     : tscarton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <h1>Menu</h1>
        <h2>Bem vindo, ${sessionScope.usuario.nome}</h2>
        <a href="<c:url value="/protegido/ListarClientes"/>">Listar Clientes</a><br/>
        <c:if test="${sessionScope.usuario.admin}">
            <a href="admin/cadastrarCliente.jsp">Cadastrar Clientes</a>
        </c:if>
        
        <br/>
        <br/>
        <a href="<c:url value="/LogoutServlet"/>">Sair</a>
        <br/>
        <br/>
        <c:if test="${sessionScope.listaClientes != null}">
            <h2>Clientes salvos na sessão</h2>
            <c:forEach items="${sessionScope.listaClientes}" var="cliente">
                <span>${cliente}</span><br/>
            </c:forEach> 
        </c:if>
        
    </body>
</html>

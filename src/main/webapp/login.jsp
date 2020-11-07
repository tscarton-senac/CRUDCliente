<%-- 
    Document   : login
    Created on : Nov 6, 2020, 8:29:21 PM
    Author     : tscarton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@include file="header.jsp" %>
    <body class="container">
        <h1>Login</h1>
        <c:if test="${param.erro != null}">
           <div class="alert alert-danger" role="alert">
            Usuário/Senha inválidos!
           </div>
        </c:if>
        
        <form action="LoginServlet" method="POST">
            <div class="form-group">
            <label>Login</label>
            <input name="login" class="form-control" required/>
            </div>
            <div class="form-group">
                <label>Senha</label>
                <input type="password" name="senha" class="form-control" required/>
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
        
        
    </body>
</html>

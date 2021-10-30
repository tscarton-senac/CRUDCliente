<%-- 
    Document   : login
    Created on : 29/10/2021, 19:24:46
    Author     : tiago.bscarton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="${pageContext.request.contextPath}/lib/bootstrap-4.1.3-dist/css/bootstrap.min.css"
              rel="stylesheet" type="text/css"/>
    </head>
    <body class="container">
        <h1>Formulário de Login</h1>
        <form action="LoginServlet" method="POST">
            <div class="form-group">
                <label for="nomeUsuario">Usuário</label>
                <input type="text" class="form-control" id="nomeUsuario" name="nomeUsuario" >
              </div>
              <div class="form-group">
                <label for="senhaUsuario">Password</label>
                <input type="password" class="form-control" id="senhaUsuario" name="senhaUsuario" >
              </div>
            
            <button type="submit" class="btn btn-primary">Enviar</button>
            
        </form>

    </body>
</html>

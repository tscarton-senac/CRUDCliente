<%-- 
    Document   : header
    Created on : 01/10/2021, 19:35:46
    Author     : tiago.bscarton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/lib/jquery-3.6.0.min.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/lib/bootstrap-4.1.3-dist/css/bootstrap.min.css"
              rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/js/uteis.js"  type="text/javascript"></script>

    </head>
    <body>


        <nav class="navbar navbar-expand-md navbar-light bg-light">
            <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                       Bem vindo, ${sessionScope.usuario.nome}
                    </li>
                   
                </ul>
            </div>
           
            <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                       <a href="${pageContext.request.contextPath}/LoginServlet">Sair</a>
                    </li>
                </ul>
            </div>
        </nav>



    </body>
</html>

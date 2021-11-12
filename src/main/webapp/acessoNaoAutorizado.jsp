<%-- 
    Document   : login
    Created on : 29/10/2021, 19:24:46
    Author     : tiago.bscarton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Acesso não autorizado</title>
         <link href="${pageContext.request.contextPath}/lib/bootstrap-4.1.3-dist/css/bootstrap.min.css"
              rel="stylesheet" type="text/css"/>
    </head>
    <body class="container">
        <h2>Acesso não autorizado!</h2> <br/>
         <a href="<c:url value="/protegido/index.jsp"/>">Voltar</a>
    </body>
</html>

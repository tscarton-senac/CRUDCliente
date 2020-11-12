<%-- 
    Document   : sucesso
    Created on : Sep 25, 2020, 9:37:51 PM
    Author     : tscarton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sucesso</title>
    </head>
    <body>
        <h1>Operação executada com sucesso!</h1><br/>
        <a href="<c:url value="/protegido/index.jsp"/>">Voltar</a>
    </body>
</html>

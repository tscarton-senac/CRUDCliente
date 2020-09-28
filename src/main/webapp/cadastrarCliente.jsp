<%-- 
    Document   : cadastrarCliente
    Created on : Sep 25, 2020, 9:26:59 PM
    Author     : tscarton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Cliente</title>
    </head>
    <body>
        <h1>Cadastro</h1>
        <form action="CadastrarCliente" method="POST">
            <p>Nome</p>
            <input name="nome"/><br/>
            <p>Email</p>
            <input name="email"/><br/>
            <p>CPF</p>
            <input name="cpf"/><br/>
            
            <button type="submit">Enviar</button>
            
        </form>
    </body>
</html>

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
        <script type="text/javascript">
            var cpfRemocao;
            function confirmarRemocao(nome, cpf) {
                console.log("Confirmar exclusao ", nome, cpf);
                cpfRemocao = cpf;
                var paragrafoCliente = $("#campoTextoExclusao");
                paragrafoCliente.html(nome + " - " + cpf);
                
                var modalConfirmacao = $("#modalExclusao");
                modalConfirmacao.show();
            }
            
            function fecharModal() {
                var modalConfirmacao = $("#modalExclusao");
                modalConfirmacao.hide();
            }

            function deletar() {
                console.log("Excluindo cliente ", cpfRemocao);
                fecharModal();
                var url = "CadastroClienteServlet?cpfUsuario=" + cpfRemocao;
                $.ajax(url).done(function () {
                    console.log("Cliente removido!");
                    var alerta = $("#alerta");
                    alerta.css("display", "block");
                    setTimeout(function(){
                         alerta.css("display", "none");
                         location.reload();
                    }, 1000)
                }).fail(function () {
                    console.log("Erro ao remover o cliente!");
                })
            }

        </script>
    </head>
    <body class="container">
        <c:import url="../uteis/header.jsp"/>
        <div id="alerta" class="alert alert-success" role="alert" style="display:none">
           Cliente removido com sucesso!
        </div>
        <h1>Clientes</h1>

        <div class="modal" tabindex="-1" role="dialog" id="modalExclusao">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Confirmar Exclusão</h5>                       
                    </div>
                    <div class="modal-body">
                        <p>Confirmar exclusão do usuário abaixo?</p>
                        <p id="campoTextoExclusao"></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" onclick="fecharModal()">Cancelar</button>
                        <button type="button" class="btn btn-primary" onclick="deletar()">Confirmar</button>
                    </div>
                </div>
            </div>
        </div>

        <table  class="table">
            <thead>
            <td>Nome</td><td>Email</td><td>CPF</td>
        </thead>
        <tbody>
            <c:forEach var="cliente" items="${listaClientes}">
                <tr>
                    <td>${cliente.nome}</td>
                    <td>${cliente.email}</td>
                    <td>${cliente.cpf}</td>
                    <td><a href="CadastroClienteServlet?cpfUsuario=${cliente.cpf}&ope=1" >Atualizar</a></td>
                    <td><button onclick="confirmarRemocao('${cliente.nome}', '${cliente.cpf}')" class="btn btn-link">Deletar</button></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
<a href="${pageContext.request.contextPath}/index.jsp">Voltar</a>
</html>

<!DOCTYPE html>
<jsp:useBean id="Usuario" scope="session" type="beans.Usuario" > </jsp:useBean>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <link rel="stylesheet" href="./css/style.css">
        <title>Projeto Traveller</title>
    </head>
    <body>
    
        <header class="p-4 text-light cor__fundo">
            <h3>Projeto Traveller</h3>
            <h5>Área do Usuario</h5>
        </header>
        
        <div class="container my-5">
            <div class="text-center">
                <h1>Oiii <c:out value="${Usuario.nome}" ></c:out></h1>
            </div>
        </div>
        
        <h2>Beleza ?</h2>
           
    </body>
</html>
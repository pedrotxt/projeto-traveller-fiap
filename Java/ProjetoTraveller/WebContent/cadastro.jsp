<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Usuario</title>
</head>
<body>
	<form action="./cadastro" method="POST" 
		 enctype="multipart/form-data">
	
	Nome
	<input type="text" id="txtNome" name="txtNome" class="form-control">
    
    Sobrenome   
	<input type="text" id="txtSobrenome" name="txtSobrenome" class="form-control">

	Email
    <input type="email" id="txtEmail" name="txtEmail" class="form-control">

	Senha
	<input type="password" class="form-control senha" id="txtSenha" name="txtSenha" >
         
	Telefone  
	<input type="number" class="form-control" id="txtTelefone" name="txtTelefone">

	<button class="btn btn-primary" type="submit">
            Enviar Dados</button>
    </form>

</body>
</html>
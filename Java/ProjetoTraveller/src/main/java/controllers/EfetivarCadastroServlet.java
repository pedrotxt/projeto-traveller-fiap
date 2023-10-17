package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Usuario;
import dao.DataSource;
import dao.UsuarioDAO;

@WebServlet("/cadastro")
public class EfetivarCadastroServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request,
                       HttpServletResponse response) 
                throws ServletException, IOException {
		String paginaDestino="";
		
		try {
				// usuario tem que estar conectado
			if (request.getSession()
                   .getAttribute("Usuario") != null) {
				
				//recuperando dados que virão do formulário
				String txtNome =
                      request.getParameter("txtNome");
				String txtSobrenome =
	                      request.getParameter("txtSobrenome");
				String txtSenha =
	                      request.getParameter("txtSenha");
				String txtEmail =
                      request.getParameter("txtEmail");
				int txtTelefone = Integer.parseInt(request.getParameter("txtTelefone"));
				
					// preenchimento dos dados do usuário 
				Usuario usuario = new Usuario();
				usuario.setNome(txtNome);
				usuario.setSobrenome(txtSobrenome);
				usuario.setSenha(txtSenha);
				usuario.setEmail(txtEmail);
				usuario.setCelular(txtTelefone);
				
					// gravando objeto no banco de Dados
				DataSource dataSource = new DataSource();
				UsuarioDAO udao = new UsuarioDAO(dataSource);
				udao.create(usuario);
				dataSource.getConnection().close();
				
				paginaDestino = "/sucesso.jsp";
			}
			else {
				paginaDestino = "/erro.jsp";
				request.setAttribute("ErroMSG", 
                           "Erro ao realizar cadastro!");
			}
		}
		catch(Exception ex) {
			paginaDestino = "/erro.jsp";
			request.setAttribute("ErroMSG", 
                       "Erro desconhecido no cadastro");
			ex.printStackTrace();
		}
		
		RequestDispatcher dispatcher = 
                     getServletContext()
                    .getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
		
	}
}

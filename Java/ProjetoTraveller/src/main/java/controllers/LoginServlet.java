package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Usuario;
import dao.DataSource;
import dao.UsuarioDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		String pagina = "";
		
		try {
			DataSource dataSource = new DataSource();
			
			// Passar como parametro no construtor o proprio DataSource
			// A minha classe UsuarioDAO vai ter a gestão da conexão com o meu banco de Dados
			UsuarioDAO usuarioDao = new UsuarioDAO(dataSource);
			
			Usuario usuarioLogin = new Usuario();
			// pegando parametro email e senha do meu front-end
			usuarioLogin.setEmail(request.getParameter("email"));
			usuarioLogin.setSenha(request.getParameter("senha"));
			
			// Mandando para o meu DAO o Objeto usuarioLogin preenchido com as informaçoes do front-end
			Usuario usuarioBD = usuarioDao.read(usuarioLogin);
			
			if(usuarioBD != null) {
				// Colocando Usuario encontrado na Sessão da minha aplicação
				// Para que o meu front-end pegue esses dados direto da Sessão ao inves de ir direto ao BD
				request.getSession().setAttribute("Usuario", usuarioBD);
				pagina = "/dados_usuario.jsp";
				System.out.println(usuarioBD.toString());
			}
			else {
				request.setAttribute("ErroMSG", "Usuário não encontrado");
				pagina = "/erro.jsp";
			}
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}
		catch (Exception ex) {
			System.out.println("ERRO AO LOGIN LOGINSERVLET: " + ex.getMessage());
		}
	}
}

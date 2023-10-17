package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Cidade;
import beans.Usuario;

public class UsuarioDAO implements DAO<Usuario>{

	private DataSource dataSource;
	
	public UsuarioDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public DataSource getDataSource() {
		return this.dataSource;
	}

	@Override
	public void create(Usuario object) {
		try {
			
			String SQL = "INSERT INTO usuario (id_usuario, p_nome, s_nome, email, celular, senha) VALUES (?, ?, ?, ?, ?, ?)";

            // PrepareStatment - Meu canal de execução do meu script SQL
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);

            stm.setString(1, object.getNome());
			stm.setString(2, object.getSobrenome());
			stm.setString(3, object.getEmail());
			stm.setInt(4, object.getCelular());
			stm.setString(5, object.getSenha());
			
            // Execute a consulta
            int executeQuery = stm.executeUpdate();
			
			
			int resultado = stm.executeUpdate();
			if(resultado != 0) {
				System.out.println("Usuario cadastrado com sucesso!");
			} else {
				System.out.println("Erro ao inserir usuario, Usuario não cadastrado");
				throw new RuntimeException("Erro ao inserir usuario, Usuario não cadastrado");
			}
		}
		catch(Exception ex) {
			System.out.println("Erro no método usuarioDAO.create " + ex.getMessage());
		}
	}

	@Override
	public Usuario read(Usuario object) {
		try {
			String SQL = "SELECT * FROM usuario WHERE email = ? AND SENHA = ?";
			
			// PrepareStatment - Meu canal de execução do meu script SQL
			PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
			
			// Parametros
			stm.setString(1, object.getEmail());
			stm.setString(2, object.getSenha());
			
			// Vai executar a minha consulta(executeQuery()) e armazenar em um objeto ResultSet
			ResultSet rs = stm.executeQuery();
			
			// Verificar
			// Se eu tiver alguma coisa (rs.next() no ResultSet eu vou ler
			if(rs.next()) {
				Usuario resultado = new Usuario();
				resultado.setIdUsuario(rs.getInt("ID_USUARIO"));
				resultado.setNome(rs.getString("P_NOME"));
				resultado.setSobrenome(rs.getString("S_NOME"));
				resultado.setEmail(rs.getString("EMAIL"));
				resultado.setCelular(rs.getInt("CELULAR"));
				resultado.setSenha(rs.getString("SENHA"));
				
				return resultado;
			}
			else {
				return null;
			}
		}
		catch(Exception ex) {
			System.out.println("Erro no método usuarioDAO.read " + ex.getMessage());
		}
		
		return null;
	}

	@Override
	public void update(Usuario object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Usuario object) {
		// TODO Auto-generated method stub
		
	}
}

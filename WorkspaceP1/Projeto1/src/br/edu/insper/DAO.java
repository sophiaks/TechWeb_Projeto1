package br.edu.insper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DAO")
public class DAO {
	private Connection connection = null;
	public DAO () throws ClassNotFoundException, SQLException {
		// Mudar SEMPRE - Vai ter info de conex�o de outra pessoa
		// Priorizar java.sql
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://local/tarefas", "root", "^^b^@JVg^x!6");
	}
    
	public List<Tarefa> getLista() throws SQLException {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tarefa");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setId(rs.getInt("id"));
			tarefa.setNome(rs.getString("tarefa"));
			tarefa.setEntrega(rs.getDate("data"));
			tarefa.setDescricao(rs.getString("descricao"));
			}
		stmt.close();
		rs.close();
		return tarefas;
		}
	
	public void close() throws SQLException {
		connection.close();
	}
	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void adiciona(Tarefa tarefa) throws SQLException {
		// Primeira coisa: criar sql
		// Preparar statement e executar
		String sql = "INSERT INTO Tarefas (nome, idade) VALUES (?,?)";
		// Prepared statement substitui os ??
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, tarefa.getNome());
		stmt.setDate(2, tarefa.getEntrega());
		stmt.setString(3, tarefa.getDescricao());
		stmt.execute();
		stmt.close();
	}
	
	public void altera(Tarefa tarefa) throws SQLException {
		String sql = "UPDATE Tarefas SET " + "nome=?, nascimento=?, altura=? WEHRE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setNString(1, tarefa.getNome());
		stmt.setDate(2, tarefa.getEntrega());
		stmt.setString(3, tarefa.getDescricao());
		stmt.setInt(4, tarefa.getId());
		stmt.execute();
		stmt.close();
	}
	
	public void remove(Integer id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM Tarfeas WHERE id=?");
		stmt.setLong(1,  id);
		stmt.execute();
		stmt.close();
	}
}

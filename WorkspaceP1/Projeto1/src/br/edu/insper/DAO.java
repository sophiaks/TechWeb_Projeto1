package br.edu.insper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAO {
	private Connection connection = null;
	
	public DAO () throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tarefas?serverTimezone=UTC", "root", "^^b^@JVg^x!6");
	}
    
	public List<Tarefa> getLista() throws SQLException {
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tarefa;");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Tarefa tarefa = new Tarefa();
			
			tarefa.setId(rs.getInt("id"));
			tarefa.setNome(rs.getString("tarefa"));
			tarefa.setEntrega(rs.getString("data"));
			tarefa.setDescricao(rs.getString("descricao"));
			tarefas.add(tarefa);
			}
		
		rs.close();
		stmt.close();
		
		return tarefas;
		
		}
	
	public void close() throws SQLException {
		connection.close();
	}

	public void adiciona(Tarefa tarefa) throws SQLException {
		// Primeira coisa: criar sql
		// Preparar statement e executar
		String sql = "INSERT INTO Tarefa" + "(tarefa, data, descricao) VALUES (?,?,?)";
		// Prepared statement substitui os ??
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, tarefa.getNome());
		stmt.setString(2, tarefa.getEntrega());
		stmt.setString(3, tarefa.getDescricao());
		stmt.execute();
		stmt.close();
	}
	
	public void atualiza(Tarefa tarefa) throws SQLException {
		String sql = "UPDATE Tarefa SET " + "tarefa=?, data=?, descricao=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, tarefa.getNome());
		stmt.setString(2, tarefa.getEntrega());
		stmt.setString(3, tarefa.getDescricao());
		stmt.setInt(4, tarefa.getId());
		stmt.execute();
		stmt.close();
	}
	
	public void remove(Integer id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM Tarefa WHERE id=?");
		stmt.setInt(1,  id);
		stmt.execute();
		stmt.close();
	}
}

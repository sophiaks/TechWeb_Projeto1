package br.insper.edu;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Cria
 */
@WebServlet("/Cria")
public class Cria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//html do form
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><form method='post'>");
		out.println("Nome: <input type='text' name='nome'><br>");
		out.println("Idade: <input type='number' name='idade'><br>");
		out.println("<input type='submit' value='gravar'>");
		out.println("</form></body></html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Envia pro DAO
		
		try {
		DAO dao = new DAO();
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setAltura(Double.valueOf(request.getParameter("idade")));
		Calendar dataNascimento = Calendar.getInstance();
		pessoa.setNascimento(dataNascimento);
		
		dao.adiciona(pessoa);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>ADICIONANDO</body></html>");
		dao.close();
	}
	 catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
	}
}



package br.edu.insper;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lista
 */
@WebServlet("/Lista")
public class Lista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Primeiro instanciar o DAO
		try {
			DAO dao = new DAO();
			List<Pessoa> pessoas;
		
			pessoas = dao.getLista();
			// atributo na requisicao
			request.setAttribute("pessoas", pessoas);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("lista.jsp");
			dispatcher.forward(request, response);
			
		PrintWriter out = response.getWriter();
		out.println("<html><body><table border = '1'>");
		out.println("<tr><td>ID</td><td>NOME</td></tr>");
		out.println("<tr><td>ID</td><td>ALTURA</td></tr>");
		for (Pessoa pessoa : pessoas) {
			out.println("<tr><td>" + pessoa.getId() + "</td><td>" + pessoa.getNome() + "</td></tr>" + pessoa.getNascimento().getTime() + "</td></tr>" );
			out.println("<td>" + pessoa.getAltura() + "</td></tr>");
		}
		out.println("</table></body></html>");
		dao.close();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

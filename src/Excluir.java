
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/excluir")
public class Excluir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Excluir() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession(true);
		@SuppressWarnings({ "unchecked" })
		List<String> listaSessao = (List<String>) sessao.getAttribute("listaTarefa");

		String tarefa = request.getParameter("nometarefa");
		PrintWriter out = response.getWriter();
		if(listaSessao.contains(tarefa)){
			listaSessao.remove(tarefa);
			out.print("sucesso");
		}

	}

}

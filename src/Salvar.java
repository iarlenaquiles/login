
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/salvar")
public class Salvar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Salvar() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession(true);
		PrintWriter out = response.getWriter();
		@SuppressWarnings("unchecked")
		List<String> listaSessao = (List<String>) sessao.getAttribute("listaTarefa");

		String tarefa = request.getParameter("tarefa");

		if (!listaSessao.contains(tarefa)) {
			listaSessao.add(tarefa);
			out.print("sucesso");
		}

	}

}


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/getlistatarefas")
public class GetListaTarefas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetListaTarefas() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession(true);

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();

		@SuppressWarnings("unchecked")
		List<String> listaTarefas = (List<String>) sessao.getAttribute("listaTarefa");
		if (listaTarefas.isEmpty()) {
			out.print("<tr><td>Não há tarefas cadastradas!</td></tr>");
		} else {
			out.print("<tr><th>Tarefa</th><th>Ações</th></tr>");
			for (int i = 0; i < listaTarefas.size(); i++) {
				out.print("<tr><td>" + listaTarefas.get(i) + "</td><td><button nometarefa='"
						+ listaTarefas.get(i)
						+ "' class='btn btn-primary btn-sm excluir' id='excluir'>Excluir</button><button class='btn btn-danger btn-sm' id='editar' nometarefa='"
						+ listaTarefas.get(i) + "'>Editar</button></td></tr>");
			}
		}
	}

}

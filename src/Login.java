
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		if(usuario.equals("admin") && senha.equals("teste1234")){
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuario", usuario);
			List<String> listaTarefa =  new ArrayList<String>();
			sessao.setAttribute("listaTarefa", listaTarefa);
			response.sendRedirect("principal.html");
		}else{
			response.sendRedirect("index.html");
		}
		
		
	}

}

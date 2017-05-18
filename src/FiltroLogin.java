
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class FiltroLogin implements Filter {

	public FiltroLogin() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession sessao = req.getSession(false);

		String path = req.getRequestURI();

		if (path.contains("login")) {
			chain.doFilter(request, response);
		} else if (sessao != null && sessao.getAttribute("usuario") != null) {
			chain.doFilter(request, response);
		} else {
			res.sendRedirect("login.html");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author lixia
 */
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession();

		boolean logout = request.getParameter("logout") != null;

		if (logout) {
			session.invalidate();
			request.setAttribute("message", "You have successfully logged out");
			session = request.getSession();
		}

		boolean loggedin = session.getAttribute("user") != null;
		
		if (loggedin) {
			response.sendRedirect("home");
			return;
		}

		getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	User user = new AccountService().login(username, password);

	if (user != null) {
		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		response.sendRedirect("home");
		return;
	} else {
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("message", "Invalid Authentication. Please check your username and password.");

		getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		return;

	}

	}

}

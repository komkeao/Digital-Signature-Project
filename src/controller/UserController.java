package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserDB;

@WebServlet("/account")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		UserDB userDB = new UserDB();

		if (action.equals("register")) {

			String password = request.getParameter("password");
			String cpassword = request.getParameter("cpassword");
			
			if (cpassword.equals(password)) {
				
				if(userDB.checkEmailAvailabilities(request.getParameter("email"))==1){
					User user = new User();
					user.setType(0);
					user.setSsn(request.getParameter("ssn"));
					user.setEmail(request.getParameter("email"));
					user.setPassword(request.getParameter("password"));
					user.setUsername(new String(request.getParameter("username")
							.getBytes("ISO8859_1"), "utf-8"));
					user.setAddress(new String(request.getParameter("address")
							.getBytes("ISO8859_1"), "utf-8"));
					userDB.register(user);
					HttpSession sess = request.getSession();
					sess.setAttribute(
							"name",
							new String(request.getParameter("username").getBytes(
									"ISO8859_1"), "utf-8"));
				
					response.sendRedirect("./");
					
				}else{
					request.setAttribute("err", "email");
					RequestDispatcher view = request.getRequestDispatcher("register"
							+ ".jsp");
					view.forward(request, response);
					
				}
				
			}else{
				request.setAttribute("err", "password");
				RequestDispatcher view = request.getRequestDispatcher("register"
						+ ".jsp");
				view.forward(request, response);
				
			}

		} else if (action.equals("logout")) {

			HttpSession sess = request.getSession();
			sess.setAttribute("name", null);
			sess.setAttribute("userType", null);
			sess.setAttribute("userID", null);
			sess.invalidate();
			RequestDispatcher login = request.getRequestDispatcher("login.jsp");
			request.setAttribute("Auth", "logout");
			login.forward(request, response);

		} else if (action.equals("login")) {

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			User user = userDB.login(email, password);
			if (user.getUserID() == 0) {

				RequestDispatcher login = request
						.getRequestDispatcher("login.jsp");
				request.setAttribute("Auth", "error");
				login.forward(request, response);

			} else {
				
				HttpSession sess = request.getSession();
				sess.setAttribute("name", user.getUsername());
				sess.setAttribute("userID", user.getUserID());
				sess.setAttribute("userType", user.getType());
				response.sendRedirect("./");

			}

		} else {
			response.sendRedirect("login.jsp");
		}
	}

}

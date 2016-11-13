package controller;

import java.io.IOException;


import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		
		if(sess.getAttribute("name")==null){
			response.sendRedirect("account");
		}else{
			if(sess.getAttribute("userType").equals(0)){
				RequestDispatcher view = request.getRequestDispatcher("student" + ".jsp");
				 view.forward(request, response);
			}else{
				RequestDispatcher view = request.getRequestDispatcher("teacher" + ".jsp");
				 view.forward(request, response);
			}
		}
		
	}

}

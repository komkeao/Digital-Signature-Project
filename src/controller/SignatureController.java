package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.ChecksumGenerator;
import model.SignatureDB;

/**
 * Servlet implementation class SignaureController
 */
@WebServlet("/signature")
@MultipartConfig
public class SignatureController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		InputStream inputStream = null;
		Part filePart = request.getPart("file");
		SignatureDB db = new SignatureDB();
		HttpSession sess = request.getSession();
		if (request.getParameter("type").equals("student")) {
			RequestDispatcher login = request
					.getRequestDispatcher("student.jsp");
			if (!filePart.getContentType().toString()
					.equals("application/octet-stream")) {
				inputStream = filePart.getInputStream();
				String checksum = ChecksumGenerator.generate(inputStream,
						"SHA-256");
				int userID = Integer.parseInt(sess.getAttribute("userID")
						.toString());
				int check = db.Sign(checksum, userID);
				request.setAttribute("result", check);
			} else {
				request.setAttribute("result", 0);

			}
			login.forward(request, response);
		} else if (request.getParameter("type").equals("teacher")) {

			if (filePart != null) {
				inputStream = filePart.getInputStream();
				String checksum = ChecksumGenerator.generate(inputStream,
						"SHA-256");
				model.Signature a = db.check(checksum);
				if (a.getId() != 0) {
					System.out.println("Valid:" + a.getName());
				} else {
					System.out.println("Invalid:");
				}
			}
		}

	}

}

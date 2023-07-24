package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserManager;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserManager userManager = new UserManager();
		ArrayList<User> list = userManager.getUserList();
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		UserManager manage = new UserManager();
		manage.setUser(name, age);

		RequestDispatcher rd = request.getRequestDispatcher("UserOutput.jsp");
		rd.forward(request, response);
	}

}

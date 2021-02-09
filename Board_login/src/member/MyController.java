package member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/")
public class MyController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) {
		String requestURI = request.getRequestURI();
		int cmdIdx = requestURI.lastIndexOf("/")+1;
		String command = requestURI.substring(cmdIdx);
		
		System.out.println("requestURI : " + requestURI);
		System.out.println("command : " + command);
		
		try {
			if(command.equals("") || command.equals("/"))
			{
				response.sendRedirect("login");
			}
			else if(command.equals("login"))
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
			else if(command.equals("loginSuccess"))
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/loginSuccess.jsp");
				dispatcher.forward(request, response);
			}
			else if(command.equals("join"))
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/join.jsp");
				dispatcher.forward(request, response);
			}
			else if(command.equals("MemberJoinAction")) {
				
				request.setCharacterEncoding("UTF-8");
				MemberDAO.insertMember(request);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/join.jsp");
				dispatcher.forward(request, response);
			}
			else if(command.equals("LoginCheckAction"))
			{
				request.setCharacterEncoding("utf-8");
				String id = request.getParameter("userId");
				String password = request.getParameter("userPassword");
				
				System.out.println("id(controller) ="+id);
				System.out.println("password(controller) ="+password);
				
				int check = MemberDAO.loginCheck(id, password);
				System.out.println("int check(controller) ="+check);
				
				if(check == 0) {
					request.setAttribute("faill", "0");
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
					dispatcher.forward(request, response);
				}else if(check == -1) {
					request.setAttribute("fail", "-1");
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
					dispatcher.forward(request, response);
				}else {
					request.setAttribute("sessionId", id);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/loginAfter.jsp");
					dispatcher.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}

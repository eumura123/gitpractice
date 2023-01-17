package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Kadai16;

/**
 * Servlet implementation class Kadai16_1ConfirmServlet
 */
@WebServlet("/Kadai16_1ConfirmServlet")
public class Kadai16_1ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kadai16_1ConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String agest = request.getParameter("age");
		String gender = request.getParameter("gender");
		String telst = request.getParameter("tel");
		String mail = request.getParameter("email");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(agest);
		int tel = Integer.parseInt(telst);
		
		Kadai16 kadai16 = new Kadai16(name, age, gender, tel, mail, pw, null, null);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("input_data", kadai16);
		
		String view = "WEB-INF/view/kadai16-1confirm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

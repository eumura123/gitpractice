package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Kadai16_1DAO;
import dto.Kadai16;

/**
 * Servlet implementation class Kadai16_3ConfirmServlet
 */
@WebServlet("/Kadai16_3ConfirmServlet")
public class Kadai16_3ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kadai16_3ConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String mail = request.getParameter("email");
		Kadai16 kadai16 = Kadai16_1DAO.selectkadai(mail);
		HttpSession session = request.getSession();
		
		session.setAttribute("mail", mail);
		session.setAttribute("kadai16", kadai16);
		
		String path = "";
		if(kadai16 != null) {			
			path = "WEB-INF/view/kadai16-3confirm.jsp";
		} else {
			path = "WEB-INF/view/kadai16-3n.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
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

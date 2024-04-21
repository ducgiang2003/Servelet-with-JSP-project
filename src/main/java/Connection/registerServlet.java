package Connection;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher RD = request.getServletContext().getRequestDispatcher("/WEB-INF/Views/registerForm.jsp");
		RD.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		Connection con = (Connection) request.getAttribute("con1");
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		String errorString = (String)request.getAttribute("errorString");
	    loginEntities LE = new loginEntities();
	    LE.setUserName(username);
	    LE.setPassWord(password);
		try
		{
			DAO.insertUser(con, LE);
			ConnectionPool.getConnection();
		}catch(Exception e)
		{
			errorString = e.getMessage();
			e.printStackTrace();
		}
		request.setAttribute("le", LE);
		request.setAttribute("errorString", errorString);
		if(errorString!=null)
		{
			RequestDispatcher RD = request.getServletContext().getRequestDispatcher("/WEB-INF/Views/registerForm.jsp");
			RD.forward(request, response);
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/loginServlet");
		}
	}

}

package Connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());?
		Connection con = (Connection) request.getAttribute("con1");
		String idStr = (String) request.getParameter("id");
		String errorString = (String) request.getAttribute("errorString");
		int id= 0;
		try
		{
			id= Integer.parseInt(idStr);
		}catch(Exception e)
		{
			errorString = e.getMessage();
			e.printStackTrace();
		}
		
		try
		{
			DAO.deleteList(con, id);
			ConnectionPool.close(con);
		}catch(SQLException e)
		{
			errorString = e.getMessage();
			e.printStackTrace();	
			}
		if(errorString!=null)
		{
			request.setAttribute("errorString", errorString);
			RequestDispatcher RD =request.getServletContext().getRequestDispatcher("/WEB-INF/Views/Show.jsp");
			RD.forward(request, response);
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/showList");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

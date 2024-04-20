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
 * Servlet implementation class insertList
 */
@WebServlet("/insertList")
public class insertList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher RD = request.getServletContext().getRequestDispatcher("/WEB-INF/Views/insert.jsp");
		RD.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		Connection con = (Connection) request.getAttribute("con1");
		String idStr = (String) request.getParameter("id");
		String errorString = (String) request.getAttribute("errorString");
		String yearStr = (String) request.getParameter("year");
		String name = (String) request.getParameter("name");
		String adress = (String) request.getParameter("adress");
		int id =0,year=0;
	  //Kiem tra cu phap 
		try {
			id=Integer.parseInt(idStr);
			year=Integer.parseInt(yearStr);
		}
		catch(Exception e)
		{
			errorString =e.getMessage();
			e.printStackTrace();
		}
		if(idStr==null||yearStr==null)
		{
			errorString ="Nhap sai cu phap, vui long nhap lai";
		}
		Entities et = new Entities(id, year, name, adress);
		//Thuc hien cau lenh sql 
		if(errorString==null)
		{
			try
			{
				DAO.insertList(con, et);
				ConnectionPool.close(con);
			}
			catch(SQLException e)
			{
				errorString =e.getMessage();
				e.printStackTrace();
			}
			request.setAttribute("errorString", errorString);
			request.setAttribute("et", et);
		}
		if(errorString!=null)
		{
			RequestDispatcher RD =request.getServletContext().getRequestDispatcher("/WEB-INF/Views/insert.jsp");
			RD.forward(request, response);
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/showList");
		}
	
	}
}

package Connection;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.List;
/**
 * Servlet implementation class showList
 */
@WebServlet("/showList")
public class showList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Connection con = (Connection) request.getAttribute("con1");
		String errorString =(String) request.getAttribute("errorString");
		List<Entities> list =null;
		//Thuc thi cau lenh truy van de hien len trang web
		try
		{
			list=DAO.show(con);
			ConnectionPool.close(con);
			System.out.println("Chay servlet");
		}catch(Exception e)
		{
			errorString =e.getMessage();
		}
		request.setAttribute("emps", list);
		RequestDispatcher RD = request.getServletContext().getRequestDispatcher("/WEB-INF/Views/Show.jsp");
		RD.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

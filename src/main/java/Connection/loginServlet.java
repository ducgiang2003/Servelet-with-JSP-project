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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private DAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
//		super.init();
		 dao = new DAO();
	}
	


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher RD = request.getServletContext().getRequestDispatcher("/WEB-INF/Views/loginForm.jsp");
		RD.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		Connection con = (Connection) request.getAttribute("con1");
		String errorString = (String) request.getAttribute("errorString");
		String username = (String) request.getParameter("username");
		String password =(String) request.getParameter("password");
		//Kiem tra username va password nhap tu trang web co dung voi trong co so du lieu hay khong 
		//Dau tien phai tao 1 lop entities de chua username va password tam thoi
		loginEntities LE = new loginEntities();
		//Luu du lieu da nhap tam thoi 
		LE.setUserName(username);		
		LE.setPassWord(password);
		
		//Thuc hien cau lenh sql de lay du lieu trong csdl voi where username va password
		try {
			if(dao.validate(LE, con))
			{
				HttpSession session = request.getSession();
				request.setAttribute("username", username);
			}
			else
			{
				HttpSession session = request.getSession();
				errorString = "Dang nhap that bai ,vui long thu dang nhap lai";
			}
			request.setAttribute("errorString", errorString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorString =e.getMessage();
		}
		if(errorString!=null)
		{
			RequestDispatcher RD = request.getServletContext().getRequestDispatcher("/WEB-INF/Views/loginForm.jsp");
			RD.forward(request, response);
		}
		else
			//Cannot call sendRedirect() after the response has been committed
			//It mean method sendRedirect must call once time , because after call the reponse has been committed
		{
			response.sendRedirect(request.getContextPath()+"/showList");
		}
		
	}

}

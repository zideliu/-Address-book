package action;

import dao.TxlDaoImp;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class DeleteContactAction
 */
@WebServlet("/DeleteContactAction")
public class DeleteContactAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContactAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TxlDaoImp tdi = new TxlDaoImp();	
		String contact = request.getParameter("contact");
		if(contact!=null) {
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			if(tdi.deleteContact(user.getUsername(),contact)) {
				System.out.println("删除成功！");
				request.getRequestDispatcher("maillistmanage.jhtml").forward(request, response);
			}			
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

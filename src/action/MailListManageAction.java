package action;

import dao.TxlDaoImp;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class MailListManageAction
 */
@WebServlet("/MailListManageAction")
public class MailListManageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailListManageAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TxlDaoImp tdi = new TxlDaoImp();
		User user = (User)request.getSession().getAttribute("user");
		int limit = 5;
		int totalPage = (int) Math.ceil(tdi.getContactCountByNowuser(user) / (limit * 1.0));
		int nowPage;
		String strPage = request.getParameter("nowPage");
		if (strPage == null) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(strPage);
			if(nowPage<1){
				nowPage = 1;
			}
			if(nowPage>totalPage){
				nowPage = totalPage;
			}
		}
		request.setAttribute("nowPage",nowPage);
		request.setAttribute("totalPage",totalPage);
		List<User> list=tdi.getContactByPageAndNowuser(nowPage,user);
		request.setAttribute("users",list);
		request.getRequestDispatcher("tongxunlu.jsp").forward(request, response);
		
		/*List<User> lst = udi.getAllUser() ;
		System.out.println(JSON.toJSONString(lst));
		response.getWriter().write(JSON.toJSONString(lst));*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost!!!!!!!!!");
		doGet(request, response);
	}

}

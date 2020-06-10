package action;

import com.alibaba.fastjson.JSON;
import dao.UserDao;
import dao.TxlDaoImp;
import dao.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class AddContactAction
 */
@WebServlet("/AddContactAction")
public class AddContactAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContactAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;UTF-8");
		User user = (User)request.getSession().getAttribute("user");
		String nowuser = user.getUsername();
		String name = request.getParameter("add_name");
        String email = request.getParameter("add_email");
        String phone = request.getParameter("add_phone");
        String youbian = request.getParameter("add_youbian");
		String sheng = request.getParameter("s_province");
		String shi = request.getParameter("s_city");
		String qx = request.getParameter("s_county");
		String address = "";

		if(name == ""){
			request.setAttribute("message", "请输入用户名");
			request.getRequestDispatcher("/addcontact.jsp").forward(request, response);
			return;
		}
		if(phone ==""){
			request.setAttribute("message", "请输入电话");
			request.getRequestDispatcher("/addcontact.jsp").forward(request, response);
			return;
		}
		if(email ==""){
			request.setAttribute("message", "请输入邮箱");
			request.getRequestDispatcher("/addcontact.jsp").forward(request, response);
			return;
		}

		if(sheng!=""&&shi!=""&&qx!=""){
			if(!sheng.equals(shi)){
				address=sheng+shi+qx;
			}
			else{
				address=shi+qx;
			}
		}
		else{
			request.setAttribute("message", "请输入地址");
			request.getRequestDispatcher("/addcontact.jsp").forward(request, response);
			return;
		}

		if(youbian ==""){
			request.setAttribute("message", "请输入邮编");
			request.getRequestDispatcher("/addcontact.jsp").forward(request, response);
			return;
		}

		UserDao ud = new UserDaoImpl();

		try {
			User user1 = ud.getUserByCondition(name);
			if(user1!=null)
			{
//				System.out.println("地址："+address);
				TxlDaoImp tdi = new TxlDaoImp();
				if(tdi.addContact(nowuser, name)) {
					request.setAttribute("message", "新增联系人成功");
					request.getRequestDispatcher("/addcontact.jsp").forward(request, response);
				}
			}
			else{
				request.setAttribute("message", "该用户名不存在");
				request.getRequestDispatcher("/addcontact.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopostaddcontact");
		doGet(request, response);
	}

}

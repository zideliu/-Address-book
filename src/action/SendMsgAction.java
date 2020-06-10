package action;


import dao.TxlDaoImp;
import dao.UserDao;
import dao.MessageDaoImp;
import dao.UserDaoImpl;
import entity.Message;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class SendMsgAction
 */
@WebServlet("/SendMsgAction")
public class SendMsgAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMsgAction() {
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
		String receiver = request.getParameter("receiver");
		String content = request.getParameter("content");
		if(receiver == ""){
			request.setAttribute("message", "请输入用户名");
			request.setAttribute("neirong", content);
			request.getRequestDispatcher("/sendmsg.jsp").forward(request, response);
			return;
		}

		UserDao ud = new UserDaoImpl();
		try {
			User user1 = ud.getUserByCondition(receiver);
			if(user1!=null)
			{
//				System.out.println("地址："+address);
				MessageDaoImp mdi = new MessageDaoImp();
				Message message = new Message(nowuser,receiver,content);
				if(mdi.sendMessage(message)) {
					request.setAttribute("message", "发送成功");
					request.getRequestDispatcher("/sendmsg.jsp").forward(request, response);
				}
			}
			else{
				request.setAttribute("message", "该用户名不存在");
				request.setAttribute("neirong", content);
				request.getRequestDispatcher("/sendmsg.jsp").forward(request, response);
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
		System.out.println("dopostsendmsg");
		doGet(request, response);
	}

}

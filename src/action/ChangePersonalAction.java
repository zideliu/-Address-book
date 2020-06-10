package action;


import dao.UserDaoImpl;
import entity.User;
//
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class ChangeUserMsgAction
 */
@WebServlet("/ChangeUserMsgAction")
public class ChangePersonalAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePersonalAction() {
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

        String phone = request.getParameter("change_phone");
        String email = request.getParameter("change_email");
        String youbian = request.getParameter("change_youbian");
		String sheng = request.getParameter("s_province");
		String shi = request.getParameter("s_city");
		String qx = request.getParameter("s_county");
		String address = "";
        String mima = request.getParameter("change_password");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        if(mima==""){
			mima=user.getPassword();
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
			address=user.getAddress();
		}
        String result = "";
        UserDaoImpl udi = new UserDaoImpl();
        if(udi.updateUsernoPic(user,mima,phone,email,youbian,address)) {
			user.setEmail(email);
			user.setYoubian(youbian);
			user.setPassword(mima);
			user.setPhone(phone);
			user.setAddress(address);
			session.setAttribute("user", user);
			request.setAttribute("message", "修改成功！");
			request.getRequestDispatcher("personalchange.jsp").forward(request, response);
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

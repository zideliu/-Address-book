package action;

import dao.UserDao;
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
 * Servlet implementation class RegistAction
 */
@WebServlet("/RegistAction")
public class RegistAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistAction() {
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
        // 用户名
        String username = request.getParameter("r_name");
        // 密码
        String password = request.getParameter("r_password");
        //确认密码
        String checkpwd=request.getParameter("r_password_check");
        //邮箱
        String email = request.getParameter("r_email");
        //电话
        String phone = request.getParameter("r_phone");
        //邮编
        String youbian = request.getParameter("r_youbian");

        String sheng = request.getParameter("s_province");
        String shi = request.getParameter("s_city");
        String qx = request.getParameter("s_county");
        String pic = "";
        String address = "";
        if(username == ""){
            request.setAttribute("message", "请输入用户名");
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
            return;
        }
        if(password == ""){
            request.setAttribute("message", "请输入密码");
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
            return;
        }
        if(password != "" && checkpwd =="" ){
            request.setAttribute("message", "请输入两次密码");
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
            return;
        }
        if(phone ==""){
            request.setAttribute("message", "请输入电话");
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
            return;
        }
        if(email ==""){
            request.setAttribute("message", "请输入邮箱");
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
            return;
        }
        if(!password.equals(checkpwd)){
            request.setAttribute("message", "两次密码不一致");
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
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
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
            return;
        }

        if(youbian ==""){
            request.setAttribute("message", "请输入邮编");
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
            return;
        }

        UserDao ud = new UserDaoImpl();
        String result="";
        try {
            User user1 = ud.getUserByCondition(username);
            if(user1!=null)
            {
                request.setAttribute("message", "该用户名已被注册");
                request.getRequestDispatcher("/regist.jsp").forward(request, response);
            }
            else{
                User user = new User(username, password, email, phone, youbian, pic, address);
                System.out.println("地址："+address);
                try {
                    if (ud.save(user)) {
                        request.setAttribute("message", "注册成功，请登录！");
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

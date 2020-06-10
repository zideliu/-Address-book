//LoginAction
package action;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Servlet implementation class LoginAction
 */

public class LoginAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session=request.getSession();
        // 用户名
        String username = request.getParameter("name");
        // 密码
        String pwd = request.getParameter("password");
        // 输入的验证码
        String code = request.getParameter("code");
        UserDao userDao=new UserDaoImpl();
        User user= null;
        try {
            user = userDao.getUserByCondition(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(username!=""&&pwd!="") {
            if (userDao.checkUsername(username)) {
                if(userDao.checkPassword(username,pwd)){
                    if (Globle.getCode() == null) {
                        request.setAttribute("message", "请输入验证码");
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    } else {
                        if (!Globle.getCode().equalsIgnoreCase(code) || code == null) {
                            request.setAttribute("message", "验证码不正确！");
                            request.getRequestDispatcher("/login.jsp").forward(request, response);
                        } else {
                            session.setAttribute("username",request.getParameter("name"));
                            session.setAttribute("user", user);
                            request.getRequestDispatcher("/index.jsp").forward(request, response);//请求转发
                        }
                    }
                }else {
                    request.setAttribute("message","用户名或密码不正确！");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            }else {
                request.setAttribute("message","用户名或密码不正确！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }else {
            request.setAttribute("message","请输入用户名或密码！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
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

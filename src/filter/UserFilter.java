package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserFilter implements Filter{
	
	private String checked="";
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
		System.out.println("UserFilter获得请求："+req.getRequestURI());
		String[] checkedlist = checked.split(";");
		Boolean ischecked = false;
		Boolean isloged = false;

		for(int i=0; i<checkedlist.length; i++) {
			if(checkedlist[i].equals(req.getServletPath())) {
				ischecked = true;
			}
		}

		if(req.getSession().getAttribute("user")!=null) {
			isloged = true;
		}

		if(ischecked&&!isloged) {
			res.sendRedirect("login.jsp");
			return;
		}
        chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("UserFilter被创建");
		checked = config.getInitParameter("checked");
	}
}

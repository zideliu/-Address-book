package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodingFilter implements Filter{

	private String encoding="";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest)request;
		System.out.println("EncodingFilter获得请求"+req.getRequestURI());
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("EncodingFilter被创建");
		encoding = config.getInitParameter("encoding");
	}
}

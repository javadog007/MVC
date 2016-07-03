package mengluo.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;  
	
	private static final String DEFAULT_PACKAGE_NAME = "mengluo.mvc.action.";
	
	private static final String DEFAULT_ACTION_NAME = "Action";
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		/**
		 * 用户请求路径
		 */
		String servletPath = req.getServletPath();
	
		int start = 1; //去掉用户请求路径前面的斜杠
		int end = servletPath.lastIndexOf(".do"); //去掉~后面的.do
		
		String actionName = end > start ? servletPath.substring(start,end) + DEFAULT_ACTION_NAME : "";
		
		String actionClassName = DEFAULT_PACKAGE_NAME + actionName.substring(0, 1).toUpperCase() + actionName.substring(1);
		
	    /*
	     * 得到用户请求的完整Action
	     */
		//System.out.println(actionClassName);

		
	}
}

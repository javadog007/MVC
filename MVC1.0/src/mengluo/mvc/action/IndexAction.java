package mengluo.mvc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 请求首页的Action
 *
 */
public class IndexAction implements Action{
	
	@Override
	public ActionResult execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		return new ActionResult(new ResultContent("index.jsp"),ResultType.Forward);
	}

}

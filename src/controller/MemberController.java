package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import service.DeleteService;
import service.JoinService;
import service.LoginService;
import service.ManagerSelectService;
import service.MemberService;
import service.SelectListService;
import service.UpdateService;


@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);

		MemberService service = null;
		ModelAndView mav = null;
		switch(command) {
		case "list.do" :
			service = new SelectListService();
			break;
		case "loginPage.do" :
			mav = new ModelAndView("views/login.jsp",false);	
			break;
		case "login.do" :
			service = new LoginService();
			break;
		case "managerPage.do":
			service = new ManagerSelectService();
			break;
		case "logout.do" :
			mav = new ModelAndView("views/logout.jsp",false);	
			break;
		case "joinForm.do" :
			mav = new ModelAndView("views/join.jsp",false);
			break;
		case "join.do" :
			service = new JoinService();
			break;
		case "delete.do" :
			service = new DeleteService();
			break;
		case "update.do" :
			service = new UpdateService();
		}
		
		if(service != null) {
			try {
				mav = service.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(mav ==null) {
			return;
		}
		
		if(mav.isRedirect()) {
			response.sendRedirect(mav.getView());
		}else {
			request.getRequestDispatcher(mav.getView()).forward(request,response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

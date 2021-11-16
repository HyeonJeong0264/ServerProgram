package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class LoginService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		

		MemberDTO memberDto = new MemberDTO();
		memberDto.setId(id);
		memberDto.setName(name);
		
		// DB 접근을 위한 DAO
		MemberDAO dao = MemberDAO.getInstance();
		
		// 로그인 확인
		MemberDTO result = dao.selectMember(memberDto);
		
		request.setAttribute("id", id);
		request.setAttribute("name", name);

		// 결과에 따른 응답(response) 처리


		// DML(insert, update, delete) 작업 후에는 redirect 해야 한다.
		// 자바 스크립트의 loaction.href는 redirect 이동과 같은 역할이다.
		if(result != null) {
			PrintWriter out = response.getWriter();
			out.println("<script>");

			out.println("location.href='/ServerProgram/managerPage.do?id="+id+"&name="+name+"';");
			out.println("</script>");
			out.close();
			
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디와 이름을 확인하세요');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			
		}
		
		return null;
	}
}

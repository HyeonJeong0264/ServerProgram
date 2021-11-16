package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;

public class DeleteService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 삭제할 사원번호 num, 전달되지 않으면 "0"으로 처리
		Optional<String> optNum = Optional.ofNullable(request.getParameter("no"));
		Long no = Long.parseLong(optNum.orElse("0"));
		
		// DB 접속을 위해서 DAO
		MemberDAO dao = MemberDAO.getInstance();
		
		// DAO의 deleteEmp() 메소드를 호출해서 삭제 실행
		int result = dao.deleteMember(no);
		
		// 결과에 따른 응답(response) 처리
		PrintWriter out = response.getWriter();
		
		// DML(insert, update, delete) 작업 후에는 redirect 해야 한다.
		// 자바 스크립트의 loaction.href는 redirect 이동과 같은 역할이다.
		if(result > 0) {
			out.println("<h1>탈퇴되었습니다.</h1>");
			out.println("<br>");
			out.println("<a href='/ServerProgram/joinForm.do'>회원가입</a>");
			out.close();
		}else {
			out.println("<script>");
			out.println("alert('삭제 실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		// 삭제 작업의 성공과 실패 모두 응답으로 처리했으므로
		// 이동이 끝난 상황이다.
		// 이런 경우 controller에 null 을 반환한다.
		
		return null;
	}

}

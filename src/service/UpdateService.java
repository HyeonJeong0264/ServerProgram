package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class UpdateService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 전달되는 파라미터
		// num : 수정할 사원의 사원 번호
		// name, salary : 수정할 내용
		
		int no =Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int point = Integer.parseInt(request.getParameter("point"));
		
		// DB로 보낼 데이터가 2개 이상인 경우
		// 하나로 묶는다(Dto 또는 Map)
		// 여기서는 Dto 생성
		MemberDTO memberDto = new MemberDTO();
		memberDto.setNo(no);
		memberDto.setName(name);
		memberDto.setPoint(point);
		
		// DB 접근을 위한 DAO
		MemberDAO dao = MemberDAO.getInstance();
		
		// 수정 실행
		int result = dao.updateMember(memberDto);
		
		// 결과에 따른 응답(response) 처리
		PrintWriter out = response.getWriter();
		
		// DML(insert, update, delete) 작업 후에는 redirect 해야 한다.
		// 자바 스크립트의 loaction.href는 redirect 이동과 같은 역할이다.
		if(result > 0) {
			out.println("<script>");
			out.println("alert('수정 성공');");
			out.println("location.href='/ServerProgram/managerPage.do?name="+name+"&id="+id+"';");
			out.println("</script>");
			out.close();
		}else {
			out.println("<script>");
			out.println("alert('수정 실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		return null;
	}

}

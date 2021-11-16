package service;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;

public class JoinService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		// DB로 보낼 데이터가 2개 이상이면 DTO또는 Map 이용하기
		/*
		EmpDto empDto = new EmpDto();
		empDto.setName(name);
		empDto.setSalary(salary);
		*/
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name",name);
		
		// DB 접근 DAO
		MemberDAO empDao = MemberDAO.getInstance();
		
		// 삽입 실행
		int result = empDao.insertMember(map);
		
		PrintWriter out = response.getWriter();
		
		// DML(insert, update, delete) 작업 후에는 redirect 해야 한다.
		// 자바 스크립트의 loaction.href는 redirect 이동과 같은 역할이다.
		if(result>0) {
			out.println("<h1>가입되었습니다.</h1>");
			out.println("<br>");
			out.println("<a href='/ServerProgram/loginPage.do'>로그인</a>");
			out.close();

		}
		return null;
	}

}

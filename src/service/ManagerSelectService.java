package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class ManagerSelectService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		

		//DB 접속하는 DAO
		MemberDAO dao = MemberDAO.getInstance();
		
		
		MemberDTO memberDto = new MemberDTO();
		memberDto.setId(id);
		memberDto.setName(name);
	
		
		// 사원번호 num과 일치하는 사원 정보를 DB에서 가져오기
		// 가져온 사원 정보를 request에 저장하고, detail.jsp로 이동하기
		request.setAttribute("id", dao.selectMember(memberDto).getId());
		request.setAttribute("name", dao.selectMember(memberDto).getName());
		request.setAttribute("grade", dao.selectMember(memberDto).getGrade());
		request.setAttribute("point", dao.selectMember(memberDto).getPoint());
		request.setAttribute("no", dao.selectMember(memberDto).getNo());
		return new ModelAndView("views/manager.jsp", false);
	}

}

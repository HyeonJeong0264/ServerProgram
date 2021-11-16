package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDAO;
import dto.MemberDTO;

public class SelectListService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MemberDTO> list = MemberDAO.getInstance().selectList();
		
		// list를 JSON 데이터로 변경 후 반환
		request.setAttribute("memberList", list);
		
		return new ModelAndView("views/list.jsp", false);
		
	}

}

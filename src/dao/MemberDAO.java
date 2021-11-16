package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.MemberDTO;
import mybatis.config.DBService;

public class MemberDAO {

	
	private SqlSessionFactory factory;
	
	private static MemberDAO instance;
	private MemberDAO() {
		factory = DBService.getInstance().getFactory();
	}
	public static MemberDAO getInstance() {
		if(instance==null) {
			instance= new MemberDAO();
		}
		return instance;
	}
	
	// 1. 제품 목록
	public List<MemberDTO> selectList(){
		SqlSession ss = factory.openSession();
		List<MemberDTO> list = ss.selectList("dao.members.selectList");
		ss.close();
		return list;
	}
	
	// 2. 로그인 성공 실패 체크
	public MemberDTO selectMember(MemberDTO meberDto){
		SqlSession ss = factory.openSession();
		MemberDTO member = ss.selectOne("dao.members.selectMember", meberDto);
		ss.close();
		return member;
	}
	
	// 3. 멤버 등록
	public int insertMember(Map<String, Object> map) {
		SqlSession ss = factory.openSession(false);
		
		int result = ss.insert("dao.members.insertMember", map);
		
		if(result > 0) {
			ss.commit();
		}
		
		ss.close();
		
		return result;
	}
	public int deleteMember(Long no) {
		SqlSession ss = factory.openSession(false);
		
		// 2) sqlmap.xml(매퍼)의 <delete> 태그 호출
		int result = ss.delete("dao.members.deleteMember",no);
		
		// 3) 삭제 성공하면 commit();
		if (result >0) {
			ss.commit();
		}
		// 4) SqlSession 객체 반납
		ss.close();
		
		// 5) 결과 반환
		return result;
	}
	public int updateMember(MemberDTO memberDto) {
		SqlSession ss = factory.openSession(false); // false commit()하고 싶어서임.
		
		int result = ss.update("dao.members.updateMember",memberDto);
		
		if(result>0) {
			ss.commit();
		}
		ss.close();
	
		return result;
	}
	
}

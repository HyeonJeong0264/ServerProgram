package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.MemberDAO;
import dto.MemberDTO;

public class Top3Job implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//STUDENT 테이블에서 ave순으로 TOP3 가져오기
		List<MemberDTO> list = MemberDAO.getInstance().selectTop1List();

		// list 파일로 만들기
		File file = new File("top1.txt");
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			for(MemberDTO student : list) {
				bw.write(student.getNo()+",");
				bw.write(student.getId()+",");
				bw.write(student.getName()+",");
				bw.write(student.getGrade()+",");
				bw.write(student.getPoint()+"\n");
				
			}
			System.out.println("top1.txt 파일 생성 완료.");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

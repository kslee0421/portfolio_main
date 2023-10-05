package portfolio;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class webpage2 {
	
	
	//파일 DB 저장 및 출력
	private filevo fv;
	
	@Resource(name="filem")
	private filemodule fm;
	
	@RequestMapping("/fileview.do")
	public String fview(Model m) {
		List<filevo> list = fm.select();
		
		m.addAttribute("data",list);
		return null;
	}
	
	//id 중복체크
	@Resource(name="members")	//인스턴스 생성
	private member_module mm;	//객체 생성

	@RequestMapping("/idcheck.do")
	public String idcheck(Model m, @RequestParam(required = false) String userid) {
		try {
			memberdto dto = mm.search_id(userid);
			if(dto == null) {
				m.addAttribute("mid","no");
			}
			else {
				//getter로드시 null일 경우 100% 오류가 발생함
				m.addAttribute("mid","yes");				
			}
		}
		catch(Exception e) {
			System.out.println("Module 접속 오류!");
			m.addAttribute("mid","error");
		}
		
		return "/WEB-INF/jsp/idcheck";
	}
	
	@Inject
	private SqlSessionFactory factory;

	@RequestMapping("/subpage.do")
	public String subpage(Model m) {
		new topclass(m,factory);
		return "subpage";
	}
	
	@RequestMapping("/index.do")
	public String index(Model m) {
		new topclass(m,factory);
		return "index";
	}
	
}


class topclass {
	SqlSession se = null;
	
	public topclass(Model m) {
		this.top(m);
		this.footer(m);
	}
	
	public topclass(Model m,SqlSessionFactory factory) {
		this.se =factory.openSession();
		this.footer(m);
	}
	
	@RequestMapping("/topmenu.do")
	public String top(Model m) {
		m.addAttribute("data","홍길동");
		return "topmenu";
	}
	
	
	@RequestMapping("/footer.do")
	public String footer(Model m) {
		System.out.println(this.se); 
		copyrightdto dto = this.se.selectOne("memberDB.copy");
		m.addAttribute("copy",dto);
		return "footer"; //null로해도됨
	}
	
}








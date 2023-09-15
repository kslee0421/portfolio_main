package portfolio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class page {
	
	@PostMapping("/search.do")
	public String search(HttpServletRequest req, Model m) {
		String s = req.getParameter("search");
		m.addAttribute("sdata",s);
		
		
		return "/WEB-INF/jsp/search";
	}
	
	@RequestMapping("/dbcheck.do")
	public void dbckeck(HttpServletRequest req, Model m) {
		Connection con = null;
		System.out.println("hello");
		try {
			con = new dbconfig().info();
			System.out.println(con.toString());
			String sql = "select count(*) as cnt from member";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			System.out.println(rs.getString("cnt"));
			con.close();
		}
		catch(Exception e) {
			System.out.println("Database error");
		}
	}
}

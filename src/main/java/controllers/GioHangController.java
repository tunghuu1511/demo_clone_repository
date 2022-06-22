package controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogics.GioHang;
import businessLogics.LoaiHoaBL;

@Controller
public class GioHangController {

	@RequestMapping("/ThemGioHang")
	public String ThemVaoGioHang(@RequestParam(name = "maHoa", required = false) Integer mahoa,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		GioHang gh = (GioHang) session.getAttribute("GioHang");
		if (gh == null) {
			gh = new GioHang();
			session.setAttribute("GioHang", gh);
		}
		gh.ThemHang(mahoa, 1);
		session.setAttribute("GioHang", gh);
		return "redirect:/trang-chu.jsp";
	}

	@RequestMapping("/Gio-Hang")
	public String TrangGioHang(Model model) throws SQLException {
		model.addAttribute("dslh", LoaiHoaBL.DocTatCa());
		return "Gio-Hang";
	}
}

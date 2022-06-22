package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import businessLogics.HoaBL;
import businessLogics.LoaiHoaBL;
import javaBeans.Hoa;
import javaBeans.LoaiHoa;

@Controller
public class HoaController {
	
	@ModelAttribute 
	public void setUTF8(HttpServletRequest rq)
	{
		try {
			rq.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
		}
	}
	
	@RequestMapping("/")
	public String trangChu(Model model) {
		return "redirect:/trang-chu.jsp";
	}
	@RequestMapping("/hoa-theo-loai")
	public String hoaTheoLoai(Model model, @RequestParam(name = "maLoai",required = false) Integer maLoai , @RequestParam(name = "SoTrang",required = false) Integer SoTrang) throws SQLException {
		model.addAttribute("dslh", LoaiHoaBL.DocTatCa());
		if(maLoai != null) {
			if (SoTrang!=null)
			{
				List<Hoa> ds = HoaBL.PhanTrang(12, SoTrang, maLoai);
				model.addAttribute("dsh", ds);
				model.addAttribute("SoTrang",HoaBL.TongSoTrang(12, maLoai));
			}	
			else {
				List<Hoa> ds = HoaBL.PhanTrang(12, 1, maLoai);
				model.addAttribute("dsh", ds);
				model.addAttribute("SoTrang", HoaBL.TongSoTrang(12, maLoai));
			}
		}else {
			if (SoTrang!=null)
			{
				List<Hoa> ds = HoaBL.PhanTrang(12, SoTrang);
				model.addAttribute("dsh", ds);
				model.addAttribute("SoTrang", HoaBL.TongSoTrang(12));
			}
			else {
				List<Hoa> ds = HoaBL.PhanTrang(12, 1);
				model.addAttribute("dsh",ds );
				model.addAttribute("SoTrang", HoaBL.TongSoTrang(12));
			}
		}
		
		
		return "hoa-theo-loai";
	}
//	
//	private static String upload(String path, Part part) throws IOException {
//		String fileName = part.getSubmittedFileName();
//		try(InputStream is = part.getInputStream()){
//		try(OutputStream os = new FileOutputStream(new File(path + 
//		fileName))){
//		int len = 0;
//		byte[] bytes = new byte[1024];
//		while ( ( len = is.read(bytes, 0, 1024)) > 0) {
//		os.write(bytes, 0, len);
//		}
//		}
//		}
//		return fileName;
//	}
//	
	
	
	@RequestMapping("/them-hoa-moi")
	public String themHoaMoi(Model model) throws SQLException {
		model.addAttribute("dslh", LoaiHoaBL.DocTatCa());
		return "them-hoa";
	}
	
	
	@RequestMapping(path="/them-hoa-moi",method = RequestMethod.POST)
	public String themHoaMoi( Model model ,@RequestParam("txtHinh") MultipartFile file,HttpServletRequest request) throws SQLException, IOException, ServletException {
		Hoa h = new Hoa();
		h.setiMaLoai(Integer.parseInt(request.getParameter("cboMaLoai")));
		
		h.setStrTenHoa(request.getParameter("txtTenHoa"));
		h.setlDonGia(Long.parseLong(request.getParameter("txtDonGia")));
		
		String tmtl=request.getServletContext().getRealPath("/images/");		// Thư Mục Tải Lên
		String tt=file.getOriginalFilename();								// Tập Tin
		try {
			byte [] mb = file.getBytes();
			OutputStream os = new FileOutputStream(tmtl+tt);
			os.write(mb);
			os.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
		h.setStrHinh(file.getOriginalFilename());
		h.setStrMoTa(request.getParameter("txtMoTa"));
		HoaBL.ThemHoa(h);
		return "redirect:/trang-them-hoa-moi.jsp";
	}
	
	@RequestMapping(path = "/timkiemhoa",method = RequestMethod.POST)
	public String timkiemhoa(HttpServletRequest request) throws SQLException
	{
		List<Hoa> ds = HoaBL.TimKiemTheoTenHoa(request.getParameter("txtTenBoHoa"));
		request.setAttribute("dsHoa", ds);
		request.setAttribute("soHoaTimThay", ds.size());
		return "ket-qua-tim";
	}
	
	@RequestMapping(path = "/ChiTietHoa")
	public String ChiTietHoa(Model model,@RequestParam(name="maHoa",required = false) Integer maHoa ) throws SQLException
	{
		model.addAttribute("dslh",LoaiHoaBL.DocTatCa());
		model.addAttribute("hoa",HoaBL.DocTheoMaHoa(maHoa));
		return "chi-tiet-hoa";
	}
}

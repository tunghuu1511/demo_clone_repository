package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import businessLogics.GioHang;
import businessLogics.NguoiDungBL;
import javaBeans.NguoiDung;

@Controller
public class NguoiDungController {

	@ModelAttribute 
	public void setUTF8(HttpServletRequest rq)
	{
		try {
			rq.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	@RequestMapping(path = "/DangNhap",method = RequestMethod.POST)
	public String DangNhap(Model model,HttpServletRequest request)
	{
		String strID,strMatKhau;
		strID=request.getParameter("txtTenDN");
		strMatKhau=request.getParameter("txtMatKhau");
		NguoiDung nd = NguoiDungBL.DangNhap(strID, strMatKhau);
		HttpSession session=request.getSession();
		if (nd!=null) {
			session.setAttribute("nd", nd);
		}
		return "redirect:/trang-chu.jsp";
	}
	
	@RequestMapping(path = "/DangXuat")
	public String DangXuat(Model model,HttpServletRequest request)
	{
		HttpSession session= request.getSession();
		session.invalidate();
		return "redirect:/trang-chu.jsp";
	}
	
	@RequestMapping(path = "/TrangDangKy")
	public String DangKy()
	{
		return "TrangDangKy";
	}
	
	@RequestMapping(path = "/DangKy",method = RequestMethod.POST)
	public String DangKy(Model model,HttpServletRequest request)
	{
		String tenDN,matkhau,hoten,diachi,dienthoai,email;
		tenDN=request.getParameter("txtTenDangNhap");
		matkhau=request.getParameter("txtMatKhau");
		hoten=request.getParameter("txtHoTen");
		diachi=request.getParameter("txtDiaChi");
		dienthoai=request.getParameter("txtSoDienThoai");
		email=request.getParameter("txtEmail");
		NguoiDung nd=new NguoiDung();
		nd.setStrTenDangNhap(tenDN);
		nd.setStrMatKhau(matkhau);
		nd.setStrHoTen(hoten);
		nd.setStrDiaChi(diachi);
		nd.setStrSDT(dienthoai);
		nd.setStrEmail(email);
		nd.setStrQuyenTruyCap("KhachHang");
		if(NguoiDungBL.DangKy(nd)==1)
		{
			HttpSession session =request.getSession();
			session.setAttribute("nd", nd);
			return "redirect:/trang-chu.jsp";
		}
		return "rediect:/Trang-Dang-Ky.jsp";
	}
	
	@RequestMapping("/ThanhToanHoaDon")
	public String ThanhToanHoaDon(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		if ((Integer)session.getAttribute("XacNhan")==1) {
			return "Thanh-Toan";
		}
		session.setAttribute("XacNhan", -1);
		return "Thanh-Toan";
	}
	
	@RequestMapping(path = "/XacNhanThanhToan")
	public String XacNhanThannhToan(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		NguoiDung nd=(NguoiDung) session.getAttribute("nd");
		GioHang gh=(GioHang) session.getAttribute("GioHang");
		NguoiDungBL.ThanhToan(nd, gh);
		gh=new GioHang();
		session.setAttribute("GioHang", gh);
		session.setAttribute("XacNhan", 1);
		return "redirect:/Trang-Thanh-Toan.jsp";
	}
	
	@RequestMapping("/quan-tri")
	public String TrangQuanTri()
	{
		return "quan-tri";
	}
	
	
}

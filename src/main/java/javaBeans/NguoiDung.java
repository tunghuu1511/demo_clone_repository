package javaBeans;

public class NguoiDung {

	private int iMaKH;
	private String strTenDangNhap;
	private String strMatKhau;
	private String strQuyenTruyCap;
	private String strHoTen;
	private String strDiaChi;
	private String strSDT;
	private String strEmail;
	public int getiMaKH() {
		return iMaKH;
	}
	public void setiMaKH(int iMaKH) {
		this.iMaKH = iMaKH;
	}
	public String getStrTenDangNhap() {
		return strTenDangNhap;
	}
	public void setStrTenDangNhap(String strTenDangNhap) {
		this.strTenDangNhap = strTenDangNhap;
	}
	public String getStrMatKhau() {
		return strMatKhau;
	}
	public void setStrMatKhau(String strMatKhau) {
		this.strMatKhau = strMatKhau;
	}
	public String getStrQuyenTruyCap() {
		return strQuyenTruyCap;
	}
	public void setStrQuyenTruyCap(String strQuyenTruyCap) {
		this.strQuyenTruyCap = strQuyenTruyCap;
	}
	public String getStrHoTen() {
		return strHoTen;
	}
	public void setStrHoTen(String strHoTen) {
		this.strHoTen = strHoTen;
	}
	public String getStrDiaChi() {
		return strDiaChi;
	}
	public void setStrDiaChi(String strDiaChi) {
		this.strDiaChi = strDiaChi;
	}
	public String getStrSDT() {
		return strSDT;
	}
	public void setStrSDT(String strSDT) {
		this.strSDT = strSDT;
	}
	public String getStrEmail() {
		return strEmail;
	}
	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}
	public NguoiDung() {
		super();
	}
	public NguoiDung(int iMaKH, String strTenDangNhap, String strMatKhau, String strQuyenTruyCap, String strHoTen,
			String strDiaChi, String strSDT, String strEmail) {
		super();
		this.iMaKH = iMaKH;
		this.strTenDangNhap = strTenDangNhap;
		this.strMatKhau = strMatKhau;
		this.strQuyenTruyCap = strQuyenTruyCap;
		this.strHoTen = strHoTen;
		this.strDiaChi = strDiaChi;
		this.strSDT = strSDT;
		this.strEmail = strEmail;
	}	
}

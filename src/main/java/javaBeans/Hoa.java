package javaBeans;

import java.io.Serializable;

public class Hoa implements Serializable{
	private int iMaHoa;
	private int iMaLoai;
	private String strTenHoa;
	private long lDonGia;
	private String strHinh;
	private String strMoTa;
	public int getiMaHoa() {
		return iMaHoa;
	}
	public void setiMaHoa(int iMaHoa) {
		this.iMaHoa = iMaHoa;
	}
	public int getiMaLoai() {
		return iMaLoai;
	}
	public void setiMaLoai(int iMaLoai) {
		this.iMaLoai = iMaLoai;
	}
	public String getStrTenHoa() {
		return strTenHoa;
	}
	public void setStrTenHoa(String strTenHoa) {
		this.strTenHoa = strTenHoa;
	}
	public long getlDonGia() {
		return lDonGia;
	}
	public void setlDonGia(long lDonGia) {
		this.lDonGia = lDonGia;
	}
	public String getStrHinh() {
		return strHinh;
	}
	public void setStrHinh(String strHinh) {
		this.strHinh = strHinh;
	}
	public String getStrMoTa() {
		return strMoTa;
	}
	public void setStrMoTa(String strMoTa) {
		this.strMoTa = strMoTa;
	}
	public Hoa(int iMaHoa, int iMaLoai, String strTenHoa, long lDonGia, String strHinh, String strMoTa) {
		super();
		this.iMaHoa = iMaHoa;
		this.iMaLoai = iMaLoai;
		this.strTenHoa = strTenHoa;
		this.lDonGia = lDonGia;
		this.strHinh = strHinh;
		this.strMoTa = strMoTa;
	}
	public Hoa() {
		super();
	}
	
}

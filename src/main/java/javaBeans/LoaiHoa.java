package javaBeans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LoaiHoa implements Serializable {

	private int iMaLoai;
	private String strTenLoai;
	public int getiMaLoai() {
		return iMaLoai;
	}
	public void setiMaLoai(int iMaLoai) {
		this.iMaLoai = iMaLoai;
	}
	public String getStrTenLoai() {
		return strTenLoai;
	}
	public void setStrTenLoai(String strTenLoai) {
		this.strTenLoai = strTenLoai;
	}
	public LoaiHoa() {
		super();
	}
	public LoaiHoa(int iMaLoai, String strTenLoai) {
		super();
		this.iMaLoai = iMaLoai;
		this.strTenLoai = strTenLoai;
	}
}

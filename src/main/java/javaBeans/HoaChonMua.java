package javaBeans;

public class HoaChonMua extends Hoa {
	private int iSoLuong;

	public HoaChonMua() {
		super();
	}
	
	public HoaChonMua(Hoa hoa ,int iSoLuongMua)
	{
		super.setiMaHoa(hoa.getiMaHoa());
		super.setiMaLoai(hoa.getiMaLoai());
		super.setlDonGia(hoa.getlDonGia());
		super.setStrHinh(hoa.getStrHinh());
		super.setStrMoTa(hoa.getStrHinh());
		super.setStrTenHoa(hoa.getStrTenHoa());
		iSoLuong=iSoLuongMua;
	}

	public int getiSoLuong() {
		return iSoLuong;
	}

	public void setiSoLuong(int iSoLuong) {
		this.iSoLuong = iSoLuong;
	}
	
	public double ThanhTien()
	{
		return iSoLuong*getlDonGia();
	}
}

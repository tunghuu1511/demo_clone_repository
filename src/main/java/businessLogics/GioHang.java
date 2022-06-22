package businessLogics;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import javaBeans.Hoa;
import javaBeans.HoaChonMua;

public class GioHang {
	private Hashtable<Integer, Integer> htGioHang;

	public GioHang() {
		htGioHang=new Hashtable<Integer, Integer>();
	}
	
	public void  ThemHang(int iMaHoa,int iSoLuong )
	{
		if (htGioHang.containsKey(iMaHoa)) {
			htGioHang.replace(iMaHoa, htGioHang.get(iMaHoa)+iSoLuong);
		}
		else {
			htGioHang.put(iMaHoa, iSoLuong);
		}
	}
	
	public int TongSanPham()
	{
		return htGioHang.size();
	}
	
	public double TongThanhTien()
	{
		double dTongTien=0;
		for(int iMaHoa : htGioHang.keySet())
		{
			Hoa hoa = HoaBL.DocTheoMaHoa(iMaHoa);
			dTongTien+=hoa.getlDonGia()*htGioHang.get(iMaHoa);
		}
		return dTongTien;
	}
	
	public List<HoaChonMua> DanhSachDaMua()
	{
		List<HoaChonMua> ds=new LinkedList<HoaChonMua>();
		for(int iMaHoa:htGioHang.keySet())
		{
			Hoa hoa = HoaBL.DocTheoMaHoa(iMaHoa);
			HoaChonMua hoamua=new HoaChonMua(hoa,htGioHang.get(iMaHoa));
			ds.add(hoamua);
		}
		return ds;
	}
}

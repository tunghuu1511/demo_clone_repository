<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container-fluid">
	<div class="row" style="background-color:#e6ffff;">
		<div class="col-sm-2">
			<h4 style="color:brown;">Danh sách loại</h4>
			<c:forEach items="${dslh }" var="lh">
				<ul>
					<li><a href="trang-chu.jsp?maLoai=${lh.iMaLoai}">${lh.strTenLoai}</a></li>
				</ul>
			</c:forEach>
		</div>
		<c:if test="${sessionScope.XacNhan == -1 }">
		<div class="col-sm-10" style="background-color:#FFF;">
			<c:forEach items="${sessionScope.GioHang.DanhSachDaMua()}" var="hoa">
				<figure>
					<img src="images/${hoa.strHinh }" />
					<figcaption>
					<p><b><a href="#">${hoa.strTenHoa } X ${hoa.iSoLuong }</a></b></p>
					<fmt:setLocale value="vi-VN"/>
					<fmt:formatNumber value="${hoa.lDonGia }" type="number" var="donGia"></fmt:formatNumber>
					<p><i>Giá bán : </i> ${donGia} đ</p>
					</figcaption>
				</figure>
			</c:forEach>
		</div>
		<h4 style="color:red;" align="center">Tổng Số Tiền : ${sessionScope.GioHang.TongThanhTien() }</h4>
		<h4 style="color:blue;" align="center"><a href="XacNhanThanhToan">Xác Nhận Thanh Toán</a></h4>
		</c:if>
		<c:if test="${sessionScope.XacNhan == 1 }">
			<h4 style="color:blue;size: 50" align="center" >Cảm Ơn Bạn Đã Mua Hàng Của Chúng Tôi</h4>
		</c:if>
	</div>
</div>
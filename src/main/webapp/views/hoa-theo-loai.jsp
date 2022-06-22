<%@page import="java.util.List"%>
<%@page import="org.springframework.http.server.reactive.ChannelSendOperator"%>
<%@page import="businessLogics.HoaBL"%>
<%@page import="javaBeans.Hoa" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	
// 	int iTongSoTrang = (int)request.getAttribute("SoTrang");
// 	request.setAttribute("SoTrang", iTongSoTrang);
	
	if(request.getParameter("maLoai") !=null)
	{
		int maLoai= Integer.parseInt(request.getParameter("maLoai"));
		request.setAttribute("maLoai", maLoai);
	}
	
%>
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
		<div class="col-sm-10" style="background-color:#FFF;">
			<c:forEach items="${dsh}" var="hoa">
				<figure>
					<img src="images/${hoa.strHinh }"/>
					<figcaption>
					<p><b><a href="Trang-Chi-Tiet.jsp?maHoa=${hoa.iMaHoa}">${hoa.strTenHoa }</a></b><a href="ThemGioHang?maHoa=${hoa.iMaHoa}"><img src="images/gio_hang.jpg" style="width:20px;height:20px;"></a></p>
					<fmt:setLocale value="vi-VN"/>
					<fmt:formatNumber value="${hoa.lDonGia }" type="number" var="donGia"></fmt:formatNumber>
					<p><i>Giá bán:</i> ${donGia} đ</p>
					</figcaption>
				</figure>
			</c:forEach>
		</div>
	</div>
	<c:if test="${SoTrang >1}">
		<c:if test="${maLoai!=null }">
			<p align="center">
			<c:forEach begin="1" end="${SoTrang }" step="1" var="i" >
				<a href="trang-chu.jsp?maLoai=${maLoai }&SoTrang=${i }">${i}</a>
			</c:forEach>
			</p>
		</c:if>
		<c:if test="${ maLoai==null}">
			<p align="center">
			<c:forEach begin="1" end="${SoTrang }" step="1" var="i" >
				<a href="trang-chu.jsp?SoTrang=${i }">${i}</a>
			</c:forEach>
			</p>
		</c:if>
	</c:if>
</div>


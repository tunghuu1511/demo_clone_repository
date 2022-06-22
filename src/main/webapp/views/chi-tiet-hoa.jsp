<%@page import="businessLogics.HoaBL"%>
<%@page import="javaBeans.Hoa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
// 	int maHoa = Integer.parseInt(request.getParameter("maHoa"));
// 	Hoa hoa = HoaBL.DocTheoMaHoa(maHoa);
// 	pageContext.setAttribute("hoa", hoa);
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
		<div class="col-sm-9" style="background-color:#FFF;">
			<div style="max-width:70%;margin:20px auto;border:1px solid gray;height:auto;padding:20px;">
				<p style="display:inline-block;padding:5px 20px"><img src="images/${hoa.strHinh}" width=150 height=200 /></p>
				<div style="display:inline-block">
					<p><b>${hoa.strTenHoa}</b></p>
					<fmt:setLocale value="vi-VN" />
					<fmt:formatNumber value="${hoa.lDonGia}" type="number" var="donGia"/>
					<p><i>Giá bán:</i> ${donGia} đ</p>
					<p>Thành phần chính:<br>${hoa.strMoTa}</p>
				</div>
			</div>		
		</div>
	</div>
</div>
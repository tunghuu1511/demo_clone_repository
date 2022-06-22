<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul class="${param.kieu}">
	<li><a href="trang-chu.jsp">Trang chủ</a></li>
	<li><a href="trang-tim-kiem-hoa.jsp">Tìm kiếm hoa</a></li>
	<c:if test="${sessionScope.nd.strQuyenTruyCap.equals('QuanTri')==true }">
		<li><a href="trang-them-hoa-moi.jsp">Thêm hoa mới</a></li>
		<li><a href="Trang-Quan-Tri.jsp">Quản Trị Hệ Thống</a></li>
	</c:if>
	<li><a href="Trang-Gio-Hang.jsp">Giỏ hàng</a></li>
	<c:if test="${sessionScope.nd==null }">
		<li><a href="Trang-Dang-Ky.jsp">Đăng ký</a></li>
	</c:if>
</ul>

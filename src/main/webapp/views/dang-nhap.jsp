<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.nd != null}" >
	<form class="form-horizontal" action="DangNhap" method="post" hidden="true">
</c:if>
<c:if test="${sessionScope.nd == null}" >
	<form class="form-horizontal" action="DangNhap" method="post">
</c:if>
	<div class="form-group">
		<label class="control-label col-sm-6" style="font-weight:normal;">Tên đăng nhập</label>
		<div class="col-sm-6">
			<input class="form-control" type="text" name="txtTenDN"	value="" />
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-6" style="font-weight:normal;">Mật khẩu</label>
		<div class="col-sm-6">
			<input class="form-control" type="password"	name="txtMatKhau" value="" />
		</div>
	</div>
	<input class="btn center-block" type="submit" name="btnDangNhap" value="Đăng nhập" />
</form>

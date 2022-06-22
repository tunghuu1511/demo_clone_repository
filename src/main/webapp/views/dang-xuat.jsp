<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<p>Có thể thanh toán bằng</p>
<p>
	<img src="images/IconCardMasterCard.gif">
	<img src="images/IconCardVisa.gif">
	<img src="images/IconCardVisaE.gif">
</p>
<c:if test="${sessionScope.nd!=null }" >
	<p>Xin chào: ${sessionScope.nd.strHoTen}</p>
	<a href="DangXuat">Thoát đăng nhập</a>
</c:if>
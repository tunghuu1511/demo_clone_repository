<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Hoa đẹp</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="css/styles.css" type="text/css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2" style="padding-top:8px;">
				<img src="images/LogotypeKvitka.gif" style="width:150px;height:100px;" />
			</div>
			<div class="col-sm-10" style="background-color:#e6ffe6;padding-top:8px;">
			<c:choose>
				<c:when test="${param.page==1}">
					<%-- trang chu --%>
					<div class="col-sm-4">
						<jsp:include page="lien-he.jsp" />
					</div>
					<div class="col-sm-4">
						<jsp:include page="dang-nhap.jsp" />
					</div>
					<div class="col-sm-4">
						<jsp:include page="dang-xuat.jsp" />
					</div>
				</c:when>
				<c:when test="${param.page==2}">
					<%-- trang tim kiem --%>
					<div class="col-sm-5">
						<jsp:include page="lien-he.jsp" />
					</div>
					<div class="col-sm-7">
						<jsp:include page="tim-kiem.jsp" />
					</div>
				</c:when>
				<c:otherwise>
					<%-- cac trang khac --%>
					<div class="col-sm-5">
						<jsp:include page="lien-he.jsp" />
					</div>
					<div class="col-sm-7">
						<img src="images/top.jpg" style="width:100%;height:100%" />
					</div>
				</c:otherwise>
			</c:choose>
			</div>
		</div>
	</div>
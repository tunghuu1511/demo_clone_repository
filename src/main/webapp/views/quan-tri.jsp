<%@page import="javaBeans.LoaiHoa"%>
<%@page import="java.util.List"%>
<%@page import="businessLogics.LoaiHoaBL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//List<LoaiHoa> dslh = LoaiHoaBL.docTatCa();
	//pageContext.setAttribute("dslh", dslh);
%>
<div class="container-fluid">
	<div class="row" style="background-color:#59961F;">
		<div class="col-sm-2">
			<jsp:include page="thuc-don.jsp?kieu=thuc-don-dung" />
		</div>
	</div>
</div>
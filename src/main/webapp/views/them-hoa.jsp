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
		<div class="col-sm-10" style="background-color:#FFF;">
			<form class="form-horizontal" action="them-hoa-moi" method="post" enctype="multipart/form-data" style="max-width:600px;margin:auto;padding:20px 0;">
<!-- 				<form  action="them-hoa-moi" method="post" enctype="multipart/form-data"> -->
				<p style="font-size:18px; font-weight:600; text-align:center; padding:10px;">THÊM HOA MỚI</p>
				<div class="form-group">
					<label class="control-label col-sm-3">Tên bó hoa:</label>
					<div class="col-sm-9"> 
						<input class="form-control" type="text" name="txtTenHoa" value="${param.txtTenHoa}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">Loại hoa:</label>
					<div class="col-sm-9"> 
						<select class="form-control" name="cboMaLoai" style="max-width:150px;">
							<c:forEach items="${dslh}" var="lh">
								<option value="${lh.iMaLoai}">${lh.strTenLoai}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">Mô tả:</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="txtMoTa" rows="2" cols="40">${param.txtMoTa}</textarea>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3">Đơn giá:</label>
					<div class="col-sm-9"> 
						<input class="form-control" type="text" name="txtDonGia" value="${param.txtDonGia}" />
					</div>
				</div>
				<div class="form-group" >
					<label class="control-label col-sm-3">Hình bó hoa</label>
					<div class="col-sm-9"> 
						<input type="file" name="txtHinh" value="${param.txtHinh}" />
					</div>
				</div>
				<div class="col-sm-12" >
					<input class="btn btn-primary center-block" type="submit" name="btnThemBoHoa" value="Thêm bó hoa" />
				</div>
			</form>
		</div>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-2" style="background-color:#59961F;height:100%;">
			<jsp:include page="thuc-don.jsp?kieu=thuc-don-dung" />
		</div>
		<div class="col-sm-10">
			<p style="font-size:16px; font-weight:600; text-align:center;">Đăng Ký Thành Viên Mới</p>
			
			<form class="form-horizontal" action="DangKy" method="post">
			
				<div class="form-group">
					<label class="control-label col-sm-4">Tên Đăng Nhập</label>
					<div class="col-sm-8">
						<input class="form-control" type="text" name="txtTenDangNhap"	value="" />
					</div> 
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">Mật Khẩu</label>
					<div class="col-sm-8">
						<input class="form-control" type="password" name="txtMatKhau"	value="" />
					</div> 
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">Họ Tên</label>
					<div class="col-sm-8">
						<input class="form-control" type="text" name="txtHoTen"	value="" />
					</div> 
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">Địa Chỉ</label>
					<div class="col-sm-8">
						<input class="form-control" type="text" name="txtDiaChi"	value="" />
					</div> 
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">Số Điện Thoại</label>
					<div class="col-sm-8">
						<input class="form-control" type="number" name="txtSoDienThoai"	value="" />
					</div> 
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-4">Email</label>
					<div class="col-sm-8">
						<input class="form-control" type="text" name="txtEmail"	value="" />
					</div> 
				</div>
				
				<div class="col-sm-12">
					<input class="btn btn-primary center-block" type="submit" name="btnDangKy"	value="Đăng Ký" />
				</div>
			</form>
		</div>
	</div>
</div>
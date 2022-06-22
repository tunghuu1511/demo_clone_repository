<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<p style="font-size:16px; font-weight:600; text-align:center;">TÌM KIẾM BÓ HOA</p>
<form class="form-horizontal" action="trang-tim-kiem-hoa.jsp" method="post">
	
	<div class="form-group">
		<label class="control-label col-sm-4">Tên bó hoa</label>
		<div class="col-sm-8">
			<input class="form-control" type="text" name="txtTenBoHoa"	value="" />
		</div> 
	</div>
	
	<div class="col-sm-12">
		<input class="btn btn-primary center-block" type="submit" name="btnTimKiem"	value="Tìm kiếm" />
	</div>
</form>


<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Shose2hands</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: #eee;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 col-xs-0"></div>
			<!-- bar -->
			<div class="col-md-8 col-xs-12">



				<jsp:include page="jsp/bar.jsp" />

				<!-- end bar -->
				<div class="row">
					<!-- แถบซ้าย -->
					
					<!-- จบแถบซ้าย -->
					<!-- แถบขวา -->
					<div class=" col-md-12">
						<br>
						<div class="panel panel-default">
							<div class="panel-body">
								<!-- ============================================================================fromlogin============================================================================= -->
								<form class="form-horizontal" action="account" method="post">
									<div align="center">
										<h2>สมัครสมาชิก</h2>
									</div>
									<br> <input type="hidden" name="action" value="register" />
									<div class="form-group">
										<label for="exampleInputName2" class="col-md-3 control-label">ชื่อผู้ใช้ : </label> 
										<div class="col-md-4">
											<input type="text" name="username" class="form-control" id="exampleInputName2" placeholder="ชื่อผู้ใช้">
										</div>
									</div>

									<div class="form-group">
											<div class="form-inline">
												<label for="exampleInputEmail2" class="col-md-3 control-label">รหัสผ่าน : </label> 
													<div class="col-md-2">
														<input type="password" name="password" class="form-control" id="exampleInputEmail2" placeholder="รหัสผ่าน" size="15">
													</div>

												<label for="exampleInputEmail2" class="col-md-3 control-label">ยืนยันรหัสผ่าน : </label> 
													<div class="col-md-2">
														<input type="password" name="cpassword" class="form-control" id="exampleInputEmail2" placeholder="ยืนยันรหัสผ่าน" size="15">
														</div>

											</div>
									</div>

									<div class="form-group">
											<label for="exampleInputEmail2" class="col-md-3 control-label">SSN : </label> 
											<div class="col-md-4">
												<input type="text" name="ssn" class="form-control" id="exampleInputEmail2" placeholder="อีเมลล์">
											</div>
									</div>

									<div class="form-group">
										<label for="exampleInputEmail2" class="col-md-3 control-label">อีเมลล์ : </label> 
										<div class="col-md-4">
											<input type="email" name="email" class="form-control"id="exampleInputEmail2" placeholder="อีเมลล์">
										</div>
									</div>

									<div class="form-group">
										<label for="exampleInputEmail2" class="col-md-3 control-label">ที่อยู่ : </label>
										<div class="col-md-8">
										<textarea class="form-control" rows="3" cols="60"
											name="address"></textarea>
											</div>
									</div>
									<br> <br>
									<div align="center">
										<input type="submit" class="btn btn-primary"
											value="ยืนยันสมัครมาชิก">
									</div>
									<br>

								</form>
								<c:if test="${err=='email' }">
									<br />
									<div class="alert alert-danger">Email Already Exist.</div>
								</c:if>
								<c:if test="${err=='password' }">
									<br />
									<div class="alert alert-danger">Password Not Matching.</div>
								</c:if>
								<!-- ================================================================================================================================================================== -->
							</div>
						</div>
					</div>
					<!-- จบแถบขวา -->
				</div>
			</div>
		</div>
	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
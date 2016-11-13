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
						<br> <br>
						<div class="panel panel-default">
							<div class="panel-body">
								<!-- ============================================================================fromlogin============================================================================= -->
								<form action="account" method="post" class="form-horizontal">
									<input type="hidden" name="action" value="login" />
									<div align="center"><h2>เข้าสู่ระบบ</h2></div><br><br>
									<div class="form-group">
										<label for="exampleInputEmail1" class="col-md-4 control-label">Email address</label><div class="col-md-6"> <input
											type="text" name="email" class="form-control"
											id="exampleInputEmail1" placeholder="Email"></div>
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1" class="col-md-4 control-label">Password</label> <div class="col-md-6"><input
											type="password" name="password" class="form-control"
											id="exampleInputPassword1" placeholder="Password"></div>
									</div>
									<div align="center">
										<button type="submit" class="btn btn-primary">เข้าสู่ระบบ</button>
									</div>
									<c:if test="${Auth=='error' }">
									<br/>
										<div class="alert alert-danger">Invalid username or
											password.</div>
									</c:if>
								</form>
								<!-- ================================================================================================================================================================== -->
							</div>
							<c:if test="${Auth=='logout' }">
									<br/>
										<div class="alert alert-success">Logout success!.</div>
									</c:if>
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
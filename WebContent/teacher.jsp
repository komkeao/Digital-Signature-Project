<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ยินดีต้อนรับ</title>
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
					<!-- à¹à¸à¸à¸à¹à¸²à¸¢ -->
					<jsp:include page="jsp/leftbar.jsp" />

					<!-- à¸à¸à¹à¸à¸à¸à¹à¸²à¸¢ -->
					<!-- แถบขวา -->
					<div class=" col-md-8">
						<div class="panel panel-default">
							<div class="panel-body">
								<!-- =============================================================================main============================================================================= -->

								<div class="row">
									<form action="signature" method="post" enctype="multipart/form-data" class="form-horizontal">
										<div class="form-group">
											<label for="exampleInputPassword1"
												class="col-md-4 control-label">Upload</label>
											<div class="col-md-6">
												<input type="file" name="file" class="form-control">
											</div>
										</div>
										<input type="hidden" name="type" value="teacher">
										<div align="center">
											<button type="submit" class="btn btn-primary">ลงนาม</button>
										</div>

									</form>
								</div>
								<!-- =============================================================================main============================================================================= -->


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
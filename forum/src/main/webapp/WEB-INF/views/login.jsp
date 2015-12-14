<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ page session="false"%>
<html>
<head>
<title>Sanok Forum</title>
<%@include file="imports.jsp"%>

</head>
<body>

	<%@include file="header.jsp"%>

	<div class="container">

	<hr>
		<hr>

		
					<h4>If you insert incorrect data you  will loged As User</h4>

<hr>
		<form class="form col-md-4" method="POST" action="login">


			<div class="form-group">
				<input class="form-control" type="text" name="adminName"
					placeholder="adminName">
			</div>


			<div class="form-group">
				<input class="form-control" type="text" name="adminPassword"
					placeholder="adminPassword">
			</div>


			<button type="submit" class="btn btn-success">Submit</button>
		</form>

		

	</div>


</body>
</html>

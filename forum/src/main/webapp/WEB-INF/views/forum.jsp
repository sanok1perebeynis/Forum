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

		<div class="page-header">
		
		<p align="right">You login as User</p>
		
			<H1 align="center"> Application Forum </H1>
			

		
		</div>

		<table class="table table-striped">
			<tr>
				<th>Open Topic</th>
			
			
			<th>Name  of Author</th>
			
			
				<th>Name  of Discussion</th>



			</tr>

			<c:forEach items="${themes}" var="theme" varStatus="ps">
				<tr>
					<td><a href="/forum/forum/${theme.idTheme}"><button
								type="submit" class="btn btn-default">Open</button></a></td>

			<td><c:out value="${theme.authorName}" /></td>
					<td><c:out value="${theme.themeName}" /></td>
				</tr>
			</c:forEach>
		</table>


		<form class="form col-md-4" method="POST" action="theme/new">

			<h3 align="center">Create Discussion</h3>

			<div class="form-group">
				<input class="form-control" type="text" name="authorName"
					placeholder="authorName">
			</div>


			<div class="form-group">
				<input class="form-control" type="text" name="themeName"
					placeholder="topicName">
			</div>



			<div class="form-group">
				<textarea class="form-control" rows="3" name="themeText"></textarea>
			</div>

			<button type="submit" class="btn btn-success">Submit</button>
		</form>

	
	</div>


</body>
</html>

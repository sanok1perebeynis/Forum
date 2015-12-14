<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Topic</title>
<%@include file="imports.jsp"%>
</head>
<body>

	<%@include file="header.jsp"%>

	<div class="container">

		<div class="page-header">

			
				<H1 align="center"> <c:out value="${theme.themeName}" /></H1>
				<H3 align="right">author - <c:out value="${theme.authorName}" /></H3>

			
			<hr>

			<h2>
				<c:out value="${theme.themeText}" />
			</h2>
		</div>

		<div class="container">
			<div class="row">
			
				<div class="col-lg-8">

				
					<p class="lead">
						<c:out value="${topic.topicText}" />
					</p>

				
					<c:choose>
						<c:when test="${not empty theme.comments}">

							<c:forEach var="comments" items="${theme.comments}">


								<ul class="media-list">
									<li class="media"><a class="pull-left" href="#"> <img
											class="media-object"
											src="<c:url value="/resources/image/user.jpg"/>" />
									</a>

										<h4 class="media-heading">
											<small><c:out value="${comments.authorCommentName}" /></small>
										</h4>


										<p class="lead">
											<c:out value="   ${comments.commentText}"></c:out>
										
										</p>
									<li class="divider"></li>



								</ul>

							</c:forEach>


						</c:when>


						<c:otherwise>
							<h2>No comments</h2>
						</c:otherwise>


					</c:choose>

				</div>

			</div>

		</div>
	
	
	
		<hr>
		<div>

			<form class="form col-md-4" method="POST"
				action="comments/addcomment/${theme.idTheme}">


				<h4>Add Comment</h4>



				<div class="form-group">
					<input class="form-control" type="text" name="authorCommentName"
						placeholder="authorCommentName">
				</div>

				<div class="form-group">
					<textarea class="form-control" rows="3" name="commentText"></textarea>
				</div>



				<button type="submit" class="btn btn-success">Submit</button>
			</form>

			<hr>


		</div>
	</div>

</body>
</html>

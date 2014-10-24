<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../tags/includes.jsp" />
<body>

	<jsp:include page="../tags/header.jsp" />
	<div class="main">
		<div class="container tim-container"
			style="max-width: 800px; padding-top: 100px;min-height:510px;">
			<table class="table">
				<tr>
					<th>Id</th>
					<th>Product</th>
					<th>Price</th>
					<th>Quantity</th>
					<th></th>
				</tr>
				<c:if test="${empty items}">
					<tr>
						<td colspan="4">No Results found</td>
					</tr>
				</c:if>
				<c:if test="${! empty items}">
					<c:forEach var="item" items="${items}">
						<tr>
							<td><c:out value="${item.id}"></c:out></td>
							<td><c:out value="${item.product}"></c:out></td>
							<td><c:out value="${item.price}"></c:out></td>
							<td><c:out value="${item.quantity}"></c:out></td>
							<td>&nbsp;<a href="update/${item.id}">Edit</a> &nbsp;&nbsp;<a
								href="delete/${item.id}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>


		</div>
	</div>
	<jsp:include page="../tags/footer.jsp" />
</body>
</html>
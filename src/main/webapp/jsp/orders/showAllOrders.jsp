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
	<div class="container">
		<jsp:include page="../tags/header.jsp" />

		<table class="table">
			<tr>
				<th>Id</th>
				<th>Customer</th>
				<th>Reference</th>
				<th>OrderDate</th>
				<th></th>
			</tr>
			<c:if test="${empty orders}">
				<tr>
					<td colspan="4">No Results found</td>
				</tr>
			</c:if>
			<c:if test="${! empty orders}">
				<c:forEach var="order" items="${orders}">
					<tr>
						<td><c:out value="${order.id}"></c:out></td>
						<td><c:out value="${order.customer}"></c:out></td>
						<td><c:out value="${order.reference}"></c:out></td>
						<td><c:out value="${order.orderDate}"></c:out></td>
						<td>&nbsp;<a href="update/${order.id}">Edit</a> &nbsp;&nbsp;<a
							href="delete/${order.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>

		<jsp:include page="../tags/footer.jsp" />
	</div>
</body>
</html>
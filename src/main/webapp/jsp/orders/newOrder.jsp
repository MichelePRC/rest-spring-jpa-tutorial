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


		<form:form class="form-horizontal" action="saveOrder" method="post"
			commandName="newOrder">
			<fieldset>

				<!-- Form Name -->
				<legend>New Order</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="customer">Customer</label>
					<div class="col-md-5">
						<input id="customer" name="customer" type="text"
							placeholder="Customer" class="form-control input-md" required="">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="reference">Reference</label>
					<div class="col-md-5">
						<input id="reference" name="reference" type="text"
							placeholder="Reference" class="form-control input-md" required="">

					</div>
				</div>

				<div class="form-group ">
					<label class="col-md-4 control-label" for="reference">Items</label>
					<table class="table" style="width: 40%;">
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
									<td><input type="checkbox" value="${item.id}" id="itemId"
										name="itemId"></td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
				</div>




				<div class="form-group">
					<label class="col-md-4 "></label>
					<div class="col-md-5">
						<input type="submit" name="" value="Save" class="btn btn-primary">
						&nbsp;&nbsp; <input type="reset" name="" value="Reset"
							class="btn btn-primary"> &nbsp;&nbsp; <a
							href="<%=request.getContextPath()%>/orders/all.html"
							class="btn btn-primary"> Back</a>
					</div>
				</div>




			</fieldset>
		</form:form>


		<jsp:include page="../tags/footer.jsp" />
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../tags/includes.jsp"/> 
<body>
<jsp:include page="../tags/header.jsp"/> 
	<div class="container">
	
		
		<c:url var="url" value="${request.contextPath}/orders/update/${editOrder.id}" />


			<form:form class="form-horizontal" action="${url}" method="post" commandName="editOrder">
				<fieldset>

					<!-- Form Name -->
					<legend>New Order</legend>
					
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="id">Id</label>
						<div class="col-md-5">
							<form:input path="id" readonly="true" class="form-control input-md" />
							
						</div>
					</div>

					

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="product">Customer</label>
						<div class="col-md-5">
							<form:input path="customer" class="form-control input-md" />

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="price">Reference</label>
						<div class="col-md-5">
							<form:input path="reference" class="form-control input-md" />

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
								</tr>
							</c:forEach>
						</c:if>
					</table>
					</div>
					
					<input type="hidden" value="${items}" id="itemList" name="itemList" />


					<div class="form-group">
						<label class="col-md-4 "></label>
						<div class="col-md-5">
						<input type="submit" name="" value="Save" class="btn btn-primary"> &nbsp;&nbsp; 
						<input type="reset" name="" value="Reset" class="btn btn-primary"> &nbsp;&nbsp; 
						<a href="<%=request.getContextPath() %>/orders/all.html" class="btn btn-primary"> Back</a>
						</div>
					</div>


					

				</fieldset>
			</form:form>

	</div>
	<jsp:include page="../tags/footer.jsp"/> 
</body>
</html>
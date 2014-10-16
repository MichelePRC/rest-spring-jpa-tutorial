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


		<c:url var="url"
			value="${request.contextPath}/items/update/${editItem.id}" />


		<form:form class="form-horizontal" action="${url}" method="post"
			commandName="editItem">
			<fieldset>

				<!-- Form Name -->
				<legend>New Item</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="id">Id</label>
					<div class="col-md-5">
						<form:input path="id" readonly="true"
							class="form-control input-md" />

					</div>
				</div>



				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="product">Product</label>
					<div class="col-md-5">
						<form:input path="product" class="form-control input-md" />

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="price">Price</label>
					<div class="col-md-5">
						<form:input path="price" class="form-control input-md" />

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="quantity">Quantity</label>
					<div class="col-md-5">
						<form:input path="quantity" class="form-control input-md" />

					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 "></label>
					<div class="col-md-5">
						<input type="submit" name="" value="Save" class="btn btn-primary">
						&nbsp;&nbsp; <input type="reset" name="" value="Reset"
							class="btn btn-primary"> &nbsp;&nbsp; <input
							type="button" value="Back"
							onclick="javascript:go('/items/all.html');"
							class="btn btn-primary">
					</div>
				</div>




			</fieldset>
		</form:form>


		<jsp:include page="../tags/footer.jsp" />
	</div>
</body>
</html>
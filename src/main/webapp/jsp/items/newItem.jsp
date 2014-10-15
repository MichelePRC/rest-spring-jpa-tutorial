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

			<form:form class="form-horizontal" action="saveItem" method="post"
				commandName="newItem">
				<fieldset>

					<!-- Form Name -->
					<legend>New Item</legend>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="product">Product</label>
						<div class="col-md-5">
							<input id="product" name="product" type="text"
								placeholder="Product" class="form-control input-md" required="">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="price">Price</label>
						<div class="col-md-5">
							<input id="price" name="price" type="text" placeholder="Price"
								class="form-control input-md" required="">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="quantity">Quantity</label>
						<div class="col-md-5">
							<input id="quantity" name="quantity" type="text"
								placeholder="Quantity" class="form-control input-md">

						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 "></label>
						<div class="col-md-5">
						<input type="submit" name="" value="Save" class="btn btn-primary"> &nbsp;&nbsp; 
						<input type="reset" name="" value="Reset" class="btn btn-primary"> &nbsp;&nbsp; 
						<input type="button" value="Back" onclick="javascript:go('/items/all.html');" class="btn btn-primary">
						</div>
					</div>


					

				</fieldset>
			</form:form>

</div>
	<jsp:include page="../tags/footer.jsp"/> 
</body>
</html>
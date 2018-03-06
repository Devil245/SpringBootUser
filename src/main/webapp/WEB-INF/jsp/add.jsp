	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User registration Form</title>
	<link href="css/bootstrap.css"      rel="stylesheet">
	<link href="css/custom.css"      rel="stylesheet">
	<link href="css/main.css"      rel="stylesheet">
</head>

<body>

 	<div class="form-container">
 	
 	<h1>User Registration Form</h1>
 	
	<form:form method="POST" modelAttribute="user" commandName="user" class="form-horizontal" action="save.html">
	

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="fname">First Name</label>
				<div class="col-md-7">
					<input type="text" id="firstName" name="firstName" class="form-control input-sm"/>
					
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="lname">Last Name</label>
				<div class="col-md-7">
					<input type="text" id="lastName" name="lastName" class="form-control input-sm"/>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="city">city</label>
				<div class="col-md-7" class="form-control input-sm">
						<input type="text" id="city" name="city" class="form-control input-sm"/>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="profession">profession</label>
				<div class="col-md-7">
					<input type="text" id="profession" name="profession" class="form-control input-sm"/>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" class="btn btn-primary btn-sm">
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>
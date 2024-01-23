<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Form</title>
<style>
body {
	font-family: Arial, sans-serif;
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
	margin: 0;
}

form {
	width: 300px;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #f8f8f8;
}

label {
	display: block;
	margin-bottom: 8px;
}

input {
	width: 100%;
	padding: 8px;
	margin-bottom: 15px;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #4caf50;
	color: white;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>



	<form:form modelAttribute="mobile" method="post" action="updating">
		<h2>Mobile Details Update Form</h2>
		<label for="id">Id:</label>
		<form:input path="id" value="${mobile.getId()}" />

		<br />
		<label for="name">brand:</label>
		<form:input path="brand" value="${mobile.getBrand()}" />

		<br />

		<label for="model">model</label>
		<form:input path="model" value="${mobile.getModel()}"/>

		<br />

		<label for="ram">ram</label>
		<form:input path="ram" value="${mobile.getRam()}" />

		<br />
		<label for="price">price</label>
		<form:input path="price" value="${mobile.getPrice()}"/>

		<br />

		<input type="submit" value="update" />
	</form:form>

</body>
</html>

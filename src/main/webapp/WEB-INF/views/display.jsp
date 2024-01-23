<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  table {
    margin: 0 auto; 
    border-collapse: collapse;
    width: 60%;
  }

  th, td {
    text-align: center; 
    padding: 10px; 
  }
  
  button {
    display: block;
    margin: 20px auto; 
    width: 90px;
    background-color: green;
    height:30px;
    border: 2px solid black;
    border-radius: 5px;
  }
  .delete{
  display: block;
    margin: 20px auto; 
    width: 90px;
    background-color: red;
    height:30px;
    border: 2px solid black;
    border-radius: 5px;
  }

  a {
    text-decoration: none; 
    color: white;
    font-weight: bold;
  }
</style>

</head>
<body>
	<table border="1">
	<h3 align="center">Mobiles and their features</h3>
		<tr>
			<th>brand</th>
			<th>model</th>
			<th>ram</th>
			<th>price</th>
		</tr>

		<c:forEach var="data" items="${mydata}">
			<tr>
				<td>${data.getBrand()}</td>
				<td>${data.getModel()}</td>
				<td>${data.getRam()}</td>
				<td>${data.getPrice()}</td>
				<td><button><a href="update?id=${data.getId()}">Update</a></button>
				<td><button class="delete"><a href="delete?id=${data.getId()}">Delete</a></button>
			</tr>
		</c:forEach>
	</table>
	<button>
		<a href="create?page=create">Create</a>
	</button>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Pais" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>País</title>
</head>
<body>
<%
	Pais pais = (Pais)request.getAttribute("pais");  
%>
<p>
ID: <%=pais.getId() %><br>
Nome: <%=pais.getNome() %><br>
População: <%=pais.getPopulacao() %><br>
Área: <%=pais.getArea() %>
</p>
</body>
</html>
<%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.spring.demo.model.Person" %>
<html>
<head>
<title>Index page</title>
</head>
<body>
<h2>Recherche simple</h2>
<form action="/simplesearch" method="post">
<button type="submit">Rechercher tous</button>
</form>
<h2>Recherche avancee</h2>
<form action="/advancedSearch" method="post">

Nom : <input type="text" name="nom">
Prenom : <input type="text" name="prenom">
<button type="submit">Rechercher</button>
</form>
<%
ArrayList <Person> al = (ArrayList <Person>)
request.getAttribute("tab");
if(null!=al){
	for(Person p: al){
	out.println("Hello " + p.getNom() + " " + p.getPrenom());
	out.println("<br>");
	
	}
}
%>
</body>
</html>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head>
	<body>
		<h2>${message}</h2>
		<h1>検索したいワードを入力してください</h1>
		<form:form modelAttribute="wordView">
		<form:input path="word" />
		<input type="submit">

		<table border="1">
		<c:forEach var="message" items="${lists}">
				<tr>
					<td>${message.MEANING}</td>
				</tr>
		</c:forEach>
		</table>
	</form:form>
	</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<H1>Custom Login Page</H1>
<form action="/login" method="post">
<input type="text" name="username">
<input type="text" name="password">
<input type="checkbox" name="remember-me">REMEMBER ME
<input type="text" value="${_csrf.token}">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<button>LOGIN</button>
</form>
</body>
</html>
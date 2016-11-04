<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
<body>
    <h1>Welcome! prove your identity</h1>
    <form action="LoginServlet" method="post">
        <input placeHolder="login" type="text" name="username">
        <br>
        <input placeHolder="password" type="password" name="password">
        <br>
        <input type="submit" value="sign in">
    </form>
</body>
</body>
</html>
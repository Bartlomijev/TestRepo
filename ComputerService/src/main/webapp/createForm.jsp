<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="CreateServlet" method="post" >
        <input placeHolder="model of device" type="text" name="deviceName">
        <br>
        <input placeHolder="description of the problem" type="text" name="deviceDescription">
        <br>
        <input type="submit" name="option" value="add">
    </form>
</body>
</html>
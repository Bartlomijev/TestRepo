<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Register form</h1>
   <form  action="RegisterServlet"  method="post">
		<input placeHolder="first name" type="text" name="userFirstName">
        <br>
        <input placeHolder="last name" type="text" name="userLastName">
        <br>
        <input placeHolder="login" type="text" name="userLogin">
        <br>
        <input placeHolder="password" type="password" name="userPassword">
        <br>
        <input placeHolder="email" type="email" name="userEmail">
        <br>
        <input placeHolder="phone" type="text" name="userPhone">
        <br>
         <input placeHolder="address" type="text" name="userAddress">
        <br>
        <input type="submit" value="register">
         
    </form>

</body>
</html>
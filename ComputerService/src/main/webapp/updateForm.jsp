<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateServlet" method="post">    
        <input placeHolder="id" type="text" name="deviceId">
        <br>        
      
        <br>
         <input  type="radio" name="deviceRepairStatus" value="repaired"> repaired
          <br>  
            <input  type="radio" name="deviceRepairStatus" value="processing"> processing
          <br>  
          <input  type="radio" name="deviceRepairStatus" value="unrepaired"> unrepaired
         <br>  
        <input type="submit" name="option" value="update">
    </form>
</body>
</html>
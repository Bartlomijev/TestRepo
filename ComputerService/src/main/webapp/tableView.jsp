<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@page import="pl.ComputerService.jdbc.data.Device, java.util.List"%>  
<% Device device = (Device)request.getAttribute("device"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Table view</title>
</head>
<body>

	<%! String option; %>
	<%	option = (String)request.getAttribute("option"); %>
    <h1>Wynik zapytania <%= request.getAttribute("option") %></h1>
    
    <!-- READ ALL -->
    
    <%if (option.equals("readAll")){ %>
    
    <table style="width:50%" border="1">
    <tr>
        <th>ID</th>
        <th>NAME</th>
          <th>DESCRIPTION</th>
           <th>REPAIR STATUS</th>
    </tr> 
  
   <% List<Device> allDevices = (List<Device>)request.getAttribute("list"); %>
   <%
        if(allDevices != null) {
            for(Device d: allDevices) {
    %>
    <tr>
        <th><%= d.getDeviceId() %></th>
        <th><%= d.getDeviceName() %></th>
        <th><%= d.getDeviceDescription() %></th>
          <th><%= d.getDeviceRepairStatus() %></th>
    </tr>
    
   
    <%}
        }%>
   </table>
   <% }%>
 
    <!-- ADD  OR  SEARCH -->
    
    <%if (option.equals("add") || option.equals("search")){ %>
 
    <table style="width:50%" border="1">
    <tr>
        <th>ID</th>
        <th>NAME</th>
          <th>DESCRIPTION</th>
           <th>REPAIR STATUS</th>
    </tr>
   
    <tr>
        <th><%= device.getDeviceId() %></th>
        <th><%= device.getDeviceName() %></th>
        <th><%= device.getDeviceDescription() %></th>
          <th><%= device.getDeviceRepairStatus() %></th>
    </tr>
    
    </table>
    <%} %>
    
    <!-- UPDATE -->
    
    <%if (option.equals("update")){ %>
    
    <table style="width:50%" border="1">
    <tr>
       <th>ID</th>  
        <th>Status naprawy</th>
    </tr>
   
    <tr>
        <th><%= device.getDeviceId() %></th>
        <th><%= device.getDeviceRepairStatus() %></th>
    </tr>
    
    </table>
    <%} %>
    
    
   <!-- DELETE -->
   
    <%if (option.equals("delete")){ %>
   
    <table style="width:50%" border="1">
    <tr>
        <th>ID</th>
    </tr>
   
    <tr>
        <th><%= device.getDeviceId() %></th>
    </tr>
    
    </table>
    <%} %> 
    
<a href="LogoutServlet">log out</a> <br>
<a href="AuthorisationServlet">do another operation</a> <br>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="java.util.*,de.tub.as.smm.models.User"%>	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Management</title>
    <style>
    .tag {
        color:black;
        font-family: monospace;
        font-size: 150%;
    </style>

</head>

<body>
	<form method="POST" action="user">
		Name: <input type="text" name="name" /> <input type="submit"
			value="Add" />
	</form>
	<%
			User user = (User) request.getAttribute("newUser");
			if (user != null){
			
				%>
				
				<p class="tag">Logged In as: <%=user%> <a href="smartmeter.jsp">Proceed</a></p>
				<%
				
				
			}
	%>
	

</body>
</html>
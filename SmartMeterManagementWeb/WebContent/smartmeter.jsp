<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="java.util.*,de.tub.as.smm.models.Zaehler"%>	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Smartmeter Management</title>
</head>

<body>
	<p><% maxAmpere %></p>

	<p><% currentAmpere %></p>
	<p><% currentVolt %></p>
	
	
	

	<form method="POST" action="smartmeter">
		Name: <input type="text" name="name" />
		Maximum Ampere: <input type="text" name="maxAmpere"/>
		Maximum Volt: <input type="text" name="maxVolt"/>
		
		 <input type="submit"
			value="Add Smartmeter" />
	</form>
	<hr>
	<ol>
		<%
			@SuppressWarnings("unchecked")
			List<Zaehler> zaehler = (List<Zaehler>) request.getAttribute("smartmeter");
			if (zaehler != null) {
				for (Zaehler zaehlerObj : zaehler) {
		%>
		<li><%=zaehlerObj%> <a href="ablesung.jsp">Ablesen</a></li>
		<%
			}
		
			}
		%>
	</ol>
	<hr>
	
	

</body>
</html>
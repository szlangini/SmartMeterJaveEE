<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="java.util.*,de.tub.as.smm.models.Ablesung"%>
<%@page import="java.util.*,de.tub.as.smm.dao.AblesungDao"%>	
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ablesungen</title>
</head>

<body>

	<h1 id="smartmeter">Smartmeter <% request.getAttribute("sm"); %></h1>

	<form method="POST" action="ablesung">
		kWh: <input type="text" name="kWh" />
		<input type="submit"
		value="Ablesen" />
	</form>
	<hr>
	<ol>
		<%
			@SuppressWarnings("unchecked")
			List<Ablesung> ablesungen = (List<Ablesung>) request.getAttribute("ablesungen");
			if (ablesungen != null) {
				for (Ablesung ablesung : ablesungen) {
		%>
		<li><%=ablesung%></li>
		<%
			}
		
			}
		%>
	</ol>
	<hr>

<script>

var text = window.location.href;
var fields = text.split('=');
var fields2 = fields[1].split('&');
var id = fields[2];

document.getElementById("smartmeter").innerHTML = "Smartmeter: " + fields2[0];

</script>
	

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="java.util.*,de.tub.as.smm.models.Zaehler"%>
<%@page import="java.util.*,de.tub.as.smm.models.User"%>
<%@page import="java.util.*,de.tub.as.smm.dao.UserDao"%>
<%@page import="java.util.*,de.tub.as.smm.dao.AblesungDao"%>



	
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Smartmeter Management</title>
<style>

      .controlDiv { display: inline-block; }

</style>
 
</head>

<body>
	<div class="controlDiv">
	<% if (UserDao.current != null ) {
		%>
		
	Eingeloggt als: <%=UserDao.current%>
		
		
	<% } %>
	<a href="user.jsp" id="logOut"><button>LogOut</button></a>
	</div>



	<form method="POST" action="smartmeter">
		Name: <input type="text" name="name" />
		Maximum Ampere: <input type="text" name="maxAmpere"/>
		
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
		<li class="zaehler"><%=zaehlerObj%> 	    <a href=<%= "\"ablesung.jsp?param1=" + zaehlerObj.getName() + "&id="+ zaehlerObj.getId() + "\"" %>>
Ablesen</a></li>
		<%

		
			}
		
			}
		%>
	</ol>
	<hr>
	
	
	
<script>
document.getElementById("logOut").onclick = function() {myFunction()};

function myFunction() {
    <% UserDao.current = null; %>
}

</script>


</body>
</html>
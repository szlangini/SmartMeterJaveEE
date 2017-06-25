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
	
	<a href="smartmeter.jsp"><button>Return</button></a>
	


	<h1 id="smartmeter">Smartmeter <% request.getAttribute("sm"); %></h1>
        <img src="img/szlang.jpg" width="200px" />
        <p>Maximale Stromstärke:</p>
        <p id="max">60A</p>
        
        <h2>Aktuelle Werte:</h2>
        <p id="volt"></p>
        <p id="ampere"></p>	
		
	
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

document.getElementById("max").innerHTML = fields2[0] + "A";


var volt = document.getElementById("volt");  
var ampere = document.getElementById("ampere");
var max = parseInt(document.getElementById("max").innerHTML);        

    
// Random Numbers are generated with Math.random()   
    // 1. Volt between 220-240
    
var xv = Math.random();
    xv = xv*20;
    xv = xv + 220
    xv = xv.toFixed(1);

       
var xa = Math.random();
    xa = xa*(max+5);
    xa = xa.toFixed(1);
    
    
volt.innerHTML = xv + "V";
ampere.innerHTML = xa + "A";
    
    
// Check if ampere > max
var amp = parseInt(document.getElementById("ampere").innerHTML);

var max = parseInt(document.getElementById("max").innerHTML);        
if (amp>max){
    
ampere.style.color = "red";
ampere.innerHTML = ampere.innerHTML + ": Achtung zu hoch!!";

}else{
    
    
}



</script>
	

</body>
</html>
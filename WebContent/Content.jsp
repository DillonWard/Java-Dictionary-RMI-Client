<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dictionary Service</title>

<h1>Dictionary Service</h1>

<body>

	<form action="Content.jsp"
		method="get">

		<input name="wordInput" type="text"
			value=<%=request.getParameter("wordInput")%>> <br> <input
			type="submit" value="Submit"> <br>
			
		<%
			String word = request.getParameter("wordInput");
			out.println(word);
		%>
 
 
	</form>
	
	

</body>
</html>
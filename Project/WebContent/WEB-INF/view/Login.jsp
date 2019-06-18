<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<html>
		<head>
		 <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
			<meta http-equiv="Content-Type"
				content="text/html; charset=ISO-8859-1">
			<title>Login</title>
		</head>
		<bod>
			<form:form id="loginForm" modelAttribute="login"
				action="loginProcess" method="post">
				<table align="center">
					<tr>
						<td>
							<form:label path="username">
								Username:
							</form:label>
						</td>
						<td>
							<form:input path="username" id="username" />
						</td>
					</tr>
					<tr>
						<td>
							<form:label path="password">
								Password:
							</form:label>
						</td>
						<td>
							<form:password path="password"
								id="password" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td align="left">
							<form:button id="login" name="login">
								Login
							</form:button>
						</td>
					</tr>
					<tr></tr>
					<tr>
						<td></td>
						<td>
							<a href="home.jsp">Home</a>
						</td>
					</tr>
				</table>
			</form:form>
			<table align="center">
				<tr>
					<td style="font-style: italic; color: red;">
						${message}
					</td>
				</tr>
			</table>
			
	</body>
		</html>
		<style type="text/css">
body{
  font-family:"Arial", Serif;
  background-color:#f4f4f4;
  overflow-x:hidden;
  background-image: url("https://s.hdnux.com/photos/74/05/62/15752353/25/920x920.jpg");
  background-size:cover;
}
		</style>
</html>
		
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Nominal Roles List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>nominalRoleId</th><th>REGNO</th><th>NAME</th><th>YOJ</th><th>YEAR</th><th>DEGREE</th><th>DEPT</th><th>SECTION</th><th>EMAIL</th><th>Edit</th></tr>
    <c:forEach var="NominalRole" items="${list}"> 
    <tr>
    <td>${NominalRole.nominalRoleId}</td>
    <td>${NominalRole.regno}</td>
    <td>${NominalRole.name}</td>
    <td>${NominalRole.yoj}</td>
    <td>${NominalRole.year}</td>
    <td>${NominalRole.degree}</td>
    <td>${NominalRole.dept}</td>
    <td>${NominalRole.section}</td>
    <td>${NominalRole.email}</td>
    <td><a href="edit/${NominalRole.nominalRoleId}">Edit</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="nominalRole">Add New Nominal Role</a>
    
    
    
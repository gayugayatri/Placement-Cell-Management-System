    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Average Marks</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>nominalRoleId</th><th>REGNO</th><th>SEM-I</th><th>SEM-2</th><th>SEM-3</th><th>SEM-4</th><th>SEM-5</th><th>SEM-6</th><th>Edit</th></tr>
    <c:forEach var="AverageMarks" items="${list}"> 
    <tr>
    <td>${AverageMarks.nominalRoleId}</td>
    <td>${AverageMarks.regno}</td>
    <td>${AverageMarks.mark}</td>
    <td>${AverageMarks.mark}</td>
    <td>${AverageMarks.mark}</td>
    <td>${AverageMarks.mark}</td>
    <td>${AverageMarks.mark}</td>
    <td>${AverageMarks.mark}</td>
    <td><a href="edit/${AverageMarks.nominalRoleId}">Edit</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="averageMarks">Add marks</a>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Average Marks</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>REGNO</th><th>SEM-I</th><th>SEM-2</th><th>SEM-3</th><th>SEM-4</th><th>SEM-5</th><th>SEM-6</th><th>SEM-7</th><th>SEM-8</th><th>SEM-9</th><th>SEM-10</th><th>AVERAGE</th><th>History of arrears</th><th>Current arrears</th><th>Edit</th></tr>
    <c:forEach var="AverageMarks" items="${list}"> 
    <tr>
  
    <td>${AverageMarks.nominalRoleId}</td>
    <td>${AverageMarks.sem1Mark}</td>
    <td>${AverageMarks.sem2Mark}</td>
    <td>${AverageMarks.sem3Mark}</td>
    <td>${AverageMarks.sem4Mark}</td>
    <td>${AverageMarks.sem5Mark}</td>
    <td>${AverageMarks.sem6Mark}</td>
    <td>${AverageMarks.sem7Mark}</td>
    <td>${AverageMarks.sem8Mark}</td>
    <td>${AverageMarks.sem9Mark}</td>
    <td>${AverageMarks.sem10Mark}</td>
    <td>${AverageMarks.avgmark}</td>
    <td>${AverageMarks.hisofarrear}</td>
    <td>${AverageMarks.currentarrear}</td>
    <td><a href="edit/${AverageMarks.nominalRoleId}">Edit</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="averageMarks">Add marks</a>
    
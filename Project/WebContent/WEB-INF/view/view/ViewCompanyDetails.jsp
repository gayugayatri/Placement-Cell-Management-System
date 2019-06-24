    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Company details List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>CompanyId</th><th>Company Name</th><th>DOP</th><th>PERCENTAGE CRITERIA</th><th>HISTORY OF ARREARS</th><th>CURRENT ARREARS</th><th>Edit</th></tr>
    <c:forEach var="CompanyDetails" items="${list}"> 
    <tr>
    <td>${CompanyDetails.companyId}</td>
    <td>${CompanyDetails.CompanyName}</td>
    <td>${CompanyDetails.dop}</td>
    <td>${CompanyDetails.percentage}</td>
    <td>${CompanyDetails.hisofarrear}</td>
    <td>${NominalRole.currentarrear}</td>
   
    <td><a href="edit/${CompanyDetails.companyId}">Edit</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="companyDetails">Add New Company Details</a>
    
    
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Company details List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>COMPANY ID</th><th>COMPANY NAME</th><th>DATE OF PLACEMENT</th><th>PERCENTAGE CRITERIA</th><th>HISTORY OF ARREARS</th><th>CURRENT ARREARS</th><th>Edit</th></tr>
    <c:forEach var="companyDetails" items="${list}"> 
    <tr>
    <td>${companyDetails.companyId}</td>
    <td>${companyDetails.companyName}</td>
    <td>${companyDetails.dop}</td>
    <td>${companyDetails.percentage}</td>
    <td>${companyDetails.hisofarrear}</td>
    <td>${companyDetails.currentarrear}</td>
   
    <td><a href="edit/${CompanyDetails.companyId}">Edit</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="companyDetails">Add New Company Details</a>
    
    
    
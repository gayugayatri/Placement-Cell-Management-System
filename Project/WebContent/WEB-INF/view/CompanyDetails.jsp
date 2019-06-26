<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>
<body>
    <form:form method="post" class="example" action="saveCompanyDetails" modelAttribute="companyDetails">

   <div class="fsize">RECRUITING COMPANIES AND CRITERIA</div><br>
    Company Name:<form:input path="companyName" id="companyName"/><br><br>
    Date of placement:<form:input path="dop" id="dop"/><br><br>
    Percentage criteria:<form:input path="percentage" id="percentage"/><br><br>
    History of arrears:<form:input path="hisofarrear" id="hisofarrear"/><br><br>
    Current arrears:<form:input path="currentarrear" id="currentarrear"/><br><br>
<button type="submit">SAVE</button><br><br>
<table border="1">
<tbody><tr>
    <th scope="col">S.no</th>
    <th scope="col">Date</th>
    <th scope="col">Company Name</th>
    <th scope="col">Percentage Criteria</th>
    <th scope="col">History of Arrears</th>
    <th scope="col">Current Arrears</th>
    <th scope="col">Gender</th>
    </tr>
</tbody></table>
</form:form>
<style type="text/css">
.fsize
{
font-size:25px;
text-align:center;
}
table
{
    border-collapse:collapse;
    width:100%;
}
table,th
{
    border:1px solid black;
    width=100%;
}
button
{
width:10%;
}
</style>


</body></html>
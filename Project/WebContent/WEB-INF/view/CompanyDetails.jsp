<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<script type="text/javascript" src="./company_files/jquery.min.js.download"></script>
</head>
<body>
    <form:form method="post" class="example" action="save" modelAttribute="companyDetails">

   <div class="fsize">RECRUITING COMPANIES AND CRITERIA</div><br>
    Company Name:<form:input path="companyId" id="companyId"/><br><br>
    Date of placement:<form:input path="criteriaId" id="dateofplacement"/><br><br>
    Percentage criteria:<form:input path="dop" id="percentage"/><br><br>
    History of arrears:<form:input path="percentage" id="hoa"/><br><br>
    Current arrears:<form:input path="historyofarrears" id="curarrears"/><br><br>
    ccccc:<form:input path="currentarrears" id="curarrears"/><br><br>

    <button type="button">SAVE</button><br><br>
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
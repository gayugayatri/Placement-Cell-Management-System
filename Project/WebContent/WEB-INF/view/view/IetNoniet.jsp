<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<script type="text/javascript" src="./IET lists_files/jquery.min.js.download"></script>
</head>
<body>
<form:form method="post" class="example" action="saveIetNonIet" modelAttribute="ietnoniet">
<div class="fsize">IET AND NON IET STUDENTS</div><br>
<table>
<tbody><tr>
    <th scope="col">S.no</th>
    <th scope="col">Regno</th>
    <th scope="col">Name</th>
    </tr>
</tbody></table><br><br>
<center>
<table>
<caption>IET LIST</caption>
<tbody><tr>
    <th scope="col">S.no</th>
    <th scope="col">Regno</th>
    <th scope="col">Name</th>
</tr>
</tbody></table><br><br>
<table>
<caption>NON IET LIST</caption>
<tbody><tr>
<th scope="col">S.no</th>
    <th scope="col">Regno</th>
    <th scope="col">Name</th>
</tr>
</tbody>
</table>
</form:form>
</center>
<style type="text/css">
.fsize
{
font-size:25px;
text-align:center;
}
table
{
    border-collapse:collapse;
    width:50%;
}
table,th
{
    border:1px solid black;
    width=50%;
}

</style>
</body>
</html>
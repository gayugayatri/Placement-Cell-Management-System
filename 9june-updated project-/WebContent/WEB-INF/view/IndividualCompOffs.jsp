<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html><head><meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<script type="text/javascript" src="./offers_files/jquery.min.js.download"></script>
</head>
<body>
<form>
<div class="fsize">NUMBER OF OFFERS PROVIDED BY EACH COMPANY</div><br>

<label for="name">Company name:</label>
<input type="text" required="" maxlength="20" minlength="2" size="15" \=""><br><br>
<label for="date">Date:</label>
<input type="date"><label> / </label>
<label for="year">Year:</label>
<input type="year"><br><br>
</form>
<table border="1">
<tbody><tr>
    <th scope="col">S.no</th>
    <th scope="col">Company name</th>
    <th scope="col">Total offers</th>
    </tr>
</tbody></table>
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
table
{
    border:1px solid black;
    width:50%
}
</style>

</body></html>
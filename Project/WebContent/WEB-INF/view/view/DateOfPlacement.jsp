<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html><head><meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<script type="text/javascript" src="./upcoming_files/jquery.min.js.download"></script>
</head>
<body>
<form>
    <div class="fsize">DATES OF PLACEMENTS AND UPCOMING PLACEMENTS</div><br>

    <label for="name">Company name:</label>
    <input type="text" required="" maxlength="15" minlength="3" size="20" \=""><br><br>
    <label for="date">Date:</label>
    <input type="date" \=""><br><br>
</form>
<table border="1">
<tbody><tr>
    <th scope="col">S.no</th>
    <th scope="col">Date</th>
    <th scope="col">Company name</th>
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
    width=50%;
}
</style>
</body>
</html>
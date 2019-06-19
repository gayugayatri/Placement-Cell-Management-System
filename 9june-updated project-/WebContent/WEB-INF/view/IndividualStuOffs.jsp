<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html><head><meta http-equiv="Content-Type" content="text/html; charset=windows-1252"> 
<script type="text/javascript" src="./Individual_files/jquery.min.js.download"></script>
</head>
   <body>
<div class="fsize">INDIVIDUAL STUDENT OFFERS</div><br>

<label for="regno">Regno:</label>
<input type="text" required="" maxlength="20" minlength="3" size="20"><br><br>
<label for="offers">No.of.Offers</label>
<input type="text" required="" maxlength="20" minlength="3" size="20"><br><br>
<button type="button">Search</button><br><br>
<table border="1">
    <thead></thead>
    <tbody><tr>
        <th scope="col">S.no</th>
        <th scope="col">Regno</th>
        <th scope="col">placed company names</th>
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
}
table
{
border:1px solid black;
width:100%;
}
</style>
</body>
</html>
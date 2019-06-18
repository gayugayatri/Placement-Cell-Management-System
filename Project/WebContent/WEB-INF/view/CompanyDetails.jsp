<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html><head><meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<script type="text/javascript" src="./company_files/jquery.min.js.download"></script>
</head>
<body>
<form>
   <div class="fsize">RECRUITING COMPANIES AND CRITERIA</div><br>
    <label for="name">Company name:</label>
    <input type="text" required="" maxlength="15" minlength="5" size="20" \=""><br><br>
    <label for="Date">Date:</label>
    <input type="date" \=""><br><br>
    <label for="percentage">Percentage Criteria:</label>
    <input type="text" maxlength="15" minlength="2" size="15" \=""><br><br>
    <label for="history">History of Arrears:</label>
    <input type="checkbox" \=""><label>Yes</label>
    <input type="checkbox" \=""><label>No</label><br><br>
    <label for="current">Current Arrears:</label>
    <input type="checkbox" \=""><label>Yes</label>
    <input type="checkbox" \=""><label>No</label><br><br>
    <label for="Gender">Gender:</label>
    <select id="name">
    <option for="girls">Girls</option>
    <option for="boys">Boys</option>
    </select><br><br>
    <button type="button">SAVE</button><br><br>
</form>
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
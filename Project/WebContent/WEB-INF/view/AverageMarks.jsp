<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
<div class="fsize">AVERAGE MARKS</div><br>
<form:form method="post" class="example" action="saveAverageMarks" modelAttribute="averageMarks">
<input type="checkbox"/><label>Single Candidate Entry</label>
<input type="checkbox"/><label>Bulk Upload</label>
<input type="text" placeholder="Search.." name="search">
<button type="submit"><i class="fa fa-search"></i></button>
<button id="upload" name="upload">Upload</button></label><br><br>
Regno:<form:input path="regno" id="regno"/><br><br>
Semester:<form:input path="semester" id="semester"/>mark:<form:input path="mark" id="mark"/><br><br>
Average:<form:input path="avgmarks" id="avgmarks"/><br><br>
History of arrears:<form:input path="hisofarrears" id="hisofarrears"/><br><br>
current arrears:<form:input path="currentarrears" id="currentarrears"/><br><br>
<button type="button">Save</button>
<button type="button">Reset</button>
<button type="button">Cancel</button><br><br>

<table border="1">
<tbody><tr>
    <th scope="col">S.no</th>
    <th scope="col">Regno</th>
    <th scope="col">Name</th>
    <th scope="col">I SEM</th>
    <th scope="col">II SEM</th>
    <th scope="col">III SEM</th>
    <th scope="col">IV SEM</th>
    <th scope="col">V SEM</th>
    <th scope="col">VI SEM</th>
    <th scope="col">Overall</th>
    <th scope="col">History of Arrears</th>
    <th scope="col">Current Arrears</th>
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
}
table
{
    border:1px solid black;
    width:100%;
}
form.example button {
  width: 10%;
  padding: 8px;
  background: #2196F3;
  color: white;
  font-size: 12px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}

form.example button:hover {
  background: #0b7dda;
}

form.example::after {
  content: "";
  clear: both;
  display: table;
}
</style>
</body>
</html>
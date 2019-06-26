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
Regno:<form:select path="regno" id="regno">
<form:option value="0" label="----Select Regno----"/>
<form:options items="${regnoList}" itemValue="id" itemLabel="value"/> 
</form:select><br><br>
Sem1:<form:input path="sem1Mark" id="sem1Mark" onChange="avg()"/>%<br><br>
Sem2:<form:input path="sem2Mark" id="sem2Mark" onChange="avg()"/>%<br><br>
Sem3:<form:input path="sem3Mark" id="sem3Mark" onblur="avg()"/>%<br><br>
Sem4:<form:input path="sem4Mark" id="sem4Mark" onblur="avg()"/>%<br><br>
Sem5:<form:input path="sem5Mark" id="sem5Mark" onblur="avg()"/>%<br><br>
Sem6:<form:input path="sem6Mark" id="sem6Mark" onblur="avg()"/>%<br><br>
Sem7:<form:input path="sem7Mark" id="sem7Mark" onblur="avg()"/>%<br><br>
Sem8:<form:input path="sem8Mark" id="sem8Mark" onblur="avg()"/>%<br><br>
Sem9:<form:input path="sem9Mark" id="sem9Mark" onblur="avg()"/>%<br><br>
Sem10:<form:input path="sem10Mark" id="sem10Mark" onblur="avg()"/>%<br><br>
Average:<form:input path="avgmark" name="avgmarks" id="avgmarks" onchange="avg()"/><br><br>
History of arrears:<form:input path="hisofarrear" id="hisofarrears"/><br><br>
current arrears:<form:input path="currentarrear" id="currentarrears"/><br><br>
<button type="submit">Save</button>
<button type="button">Reset</button>
<button type="button">Cancel</button><br><br>
<script>
function avg(){
	var sem1Mark = document.getElementById("sem1Mark").value;
	var sem2Mark = document.getElementById("sem2Mark").value;
	var sem3Mark = document.getElementById("sem3Mark").value;
	var sem4Mark = document.getElementById("sem4Mark").value;
	var sem5Mark = document.getElementById("sem5Mark").value;
	var sem6Mark = document.getElementById("sem6Mark").value;
	var sem7Mark = document.getElementById("sem7Mark").value;
	var sem8Mark = document.getElementById("sem8Mark").value;
	var sem9Mark = document.getElementById("sem9Mark").value;
	var sem10Mark = document.getElementById("sem10Mark").value;
	var avgmarks= document.getElementById("avgmarks").value;
	var marks= [sem1Mark,sem2Mark,sem3Mark,sem4Mark,sem5Mark,sem6Mark,sem7Mark,sem8Mark,sem9Mark,sem10Mark];
	var count=0, totalsems=0, totalMarks=0, average=0;
	var t=0;
	for(var a=0;a<marks.length;a++)
		{
			t= parseInt(marks[a]);
			if(t>0)
			{
			 totalsems++;			 
			 totalMarks = totalMarks + t;
			}
		}
	average = totalMarks/totalsems;
	document.getElementById("avgmarks").value = average;
	//int avgmarks=sum(sem1Mark+sem2Mark+sem3Mark+sem4Mark+sem5Mark+sem6Mark+sem7Mark+sem8Mark+sem9Mark+sem10Mark)/totalsems;
	
	}
</script>
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
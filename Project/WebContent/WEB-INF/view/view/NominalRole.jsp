<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<body>
<h2><center>NOMINAL ROLE</center></h2><br><br>
<form:form method="post" class="example" action="saveNominalRole" modelAttribute="nominalRole">
<input type="checkbox"/><label>Single Candidate Entry</label>
<input type="checkbox"/><label>Bulk Upload</label>
<input type="text" placeholder="Search.." name="search">
<button type="submit"><i class="fa fa-search"></i></button>
<button id="upload" name="upload">Upload</button></label><br><br>

Regno:<form:input path="regno" id="regno"/><br><br>
Name:<form:input path="name" id="name"/><br><br>
Year of joining:<form:input path="yoj" id="yoj"/><br><br>
Year:<form:select path="year" id="year">
<form:option value="0" label="----Select Year----"/>
<form:options items="${yearList}" itemValue="id" itemLabel="value"/> 
</form:select><br><br>
Degree:<form:select path="degree" id="degree">
<form:option value="0" label="----Select Degree----"/>
<form:options items="${degreeList}" itemValue="id" itemLabel="value"/> 
</form:select><br><br>
Dept:<form:select path="dept" id="dept">
<form:option value="0" label="----Select Dept----"/>
<form:options items="${deptList}" itemValue="id" itemLabel="value"/> 
</form:select><br><br>
Section:<form:select path="section" id="section">
<form:option value="0" label="----Select Section----"/>
<form:options items="${sectionList}" itemValue="id" itemLabel="value"/> 
</form:select><br><br>
Email:<form:input path="email" id="email" size="30"/><br><br>
<button onclick="myfun()"type="submit">Save</button>
<button>Reset</button>
<button>Cancel</button><br><br>
<table border=1>
<tr>
<th scope="col">S.no</th>
<th scope="col">Regno</th>
<th scope="col">Name</th>
<th scope="col">Class</th>
</tr>
</table>
</form:form>
<style>
body
{
background-image: url("");
}
fsize
{
font-weight:bold;
}
table
{
 border:1px solid black;
 width:60%;
 border-collapse:collapse;    
}
form.example button {
 
  width: 10%;
  padding: 5px;
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
<script>
function myfun()
{
var regno = document.getElementById("regno").value;
var name = document.getElementById("name").value;
var yoj = document.getElementById("yoj").value;
var year = document.getElementById("year").value;
var degree = document.getElementById("degree").value;
var dept = document.getElementById("dept").value;
var section = document.getElementById("section").value;
var email=document.getElementById("email").value;
var regformat=/^[a-zA-Z0-9_]*$/;
var emailformat=/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
var flag=true;
if(regno == "" || regno == undefined || !regno.match(regformat) )
{
alert("please enter a valid regno");
flag=false;
}
else if(name == "" || name == undefined)
{
alert("please enter the name");
flag=false;
}
else if(yoj == "" || yoj == undefined)
{
alert("please enter the year of joining");
flag=false;
}
else if(year == "" || year == undefined)
{
alert("please enter the year");
flag=false;
}
else if(degree == "" || degree == undefined)
{
alert("please enter the degree");
flag=false;
}
else if(dept == ""|| dept == undefined)
{
alert("please enter the dept");
flag=false;
}
else if(section == ""|| section == undefined)
{
alert("please enter the section");
flag=false;
}
else if(email == "" || email == undefined || !email.match(emailformat))
{
alert("please enter valid email");
}
}
</script>
</html>


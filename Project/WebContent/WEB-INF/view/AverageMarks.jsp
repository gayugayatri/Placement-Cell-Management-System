<!DOCTYPE html>
<!-- saved from url=(0051)file:///C:/Users/computer/Downloads/percentage.html -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<script type="text/javascript" src="./percentage_files/jquery.min.js.download"></script>
</head>
<body>
<div class="fsize">AVERAGE MARKS</div><br>
<input type="checkbox" \=""><label>Single Candidate Entry</label>
<input type="checkbox" \=""><label>Bulk upload</label>
<input type="search" placeholder="Search">
<input type="submit" value="Search">
<button>Upload</button><br><br>
Regno:<form:input path="regno" id="regno"/><br><br>
marks:<form:select path="semester" id="semester">
<form:option value="0" label="----Select Semester----"/>
<form:options items="${semesterList}" itemValue="id" itemLabel="value"/> 
</form:select><input type="text" id="marks" path="marks">
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
  float: left;
  width: 20%;
  padding: 10px;
  background: #2196F3;
  color: white;
  font-size: 17px;
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
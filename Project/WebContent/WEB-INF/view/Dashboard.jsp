<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Dashboard</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <nav class="navbar">
    <span class="open-slide">
      <a href="#" onclick="openSlideMenu()">
        <svg width="30" height="30">
            <path d="M0,5 30,5" stroke="#fff" stroke-width="5"/>
            <path d="M0,14 30,14" stroke="#fff" stroke-width="5"/>
            <path d="M0,23 30,23" stroke="#fff" stroke-width="5"/>
        </svg>
      </a>
    </span>
		    <ul class="navbar-nav">
			<h1>Placement Cell Management System<h1>
	
    </ul>

  </nav>

  <div id="side-menu" class="side-nav">
    <a href="#" class="btn-close" onclick="closeSlideMenu()">&times;</a>
    <a href="/ExamCell/nominalRole">Nominal Role</a>
    <a href="ExamCell/CompanyDetails">IET NON IET</a>
    <a href="ExamCell/CompanyDetails">Recruiting Company</a>
    <a href="ExamCell/EligibleCandidates">Eligible Candidates</a>
    <a href="ExamCell/ComWisePlcdStu">Company wise Placed Students</a>
    <a href="ExamCell/IndividualStuOffs">Individual Offers</a>
    <a href="ExamCell/IndividualCompOffs">Individual Company Offers</a>
  </div>

  <div id="main">
    <h1>Dashboard</h1>
  </div>

  <script>
    function openSlideMenu(){
      document.getElementById('side-menu').style.width = '250px';
      document.getElementById('main').style.marginLeft = '250px';
    }

    function closeSlideMenu(){
      document.getElementById('side-menu').style.width = '0';
      document.getElementById('main').style.marginLeft = '0';
    }
  </script>
</body>
</html>
<style type="text/css">
body{
  font-family:"Arial", Serif;
  background-color:#f4f4f4;
  overflow-x:hidden;
  background-image: url("https://s.hdnux.com/photos/74/05/62/15752353/25/920x920.jpg");
  background-size:cover;
}

.navbar{
  background-color:#111;
  overflow:hidden;
  height:63px;
  opacity:0.9;
}
.navbar-nav{
color:white;
}

.navbar a{
  float:left;
  display:block;
  color:#f2f2f2;
  text-align:center;
  padding:14px 16px;
  text-decoration:none;
  font-size:17px;
}

.navbar ul{
  margin:8px 0 0 0;
  list-style:none;
}

.navbar a:hover{
  background-color:#ddd;
  color:#000;
}

.side-nav{
  height:100%;
  width:0;
  position:fixed;
  z-index:1;
  top:0;
  left:0;
  background-color:#111;
  opacity:0.9;
  overflow-x:hidden;
  padding-top:60px;
  transition:0.5s;
}

.side-nav a{
  padding:10px 10px 10px 30px;
  text-decoration:none;
  font-size:22px;
  color:#ccc;
  display:block;
  transition:0.3s;
}

.side-nav a:hover{
  color:#fff;
}

.side-nav .btn-close{
  position:absolute;
  top:0;
  right:22px;
  font-size:36px;
  margin-left:50px;
}

#main{
  transition:margin-left 0.5s;
  padding:20px;
  overflow:hidden;
  width:100%;
}

@media(max-width:568px){
  .navbar-nav{display:none}
}

@media(min-width:568px){
  /*.open-slide{display:none}*/
}
</style>
</html>
    
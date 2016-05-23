
<!DOCTYPE html>
<html lang="en">
<head>
<title>User Homepage</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body bgcolor="#ADD8E6">
	<h2>
		Welcome
		<%=session.getAttribute("userName")%></h2>
		
		
	<div class="container">

		<ul class="nav nav-tabs">
			<li><a href="#">Home</a>
			</li>
			<li><a href="EditInfo.jsp">Profile Setting</a>
			</li>
			<li><a href="#">Upload DICOM</a>
			</li>
			<li><a href="logout.jsp">Logout</a>
			</li>

		</ul>


	</div>

</body>
</html>



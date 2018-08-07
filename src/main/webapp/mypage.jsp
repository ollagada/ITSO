<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--   ---------CDN 모음 ------------------------------------------  -->
<!-- jquery  -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap core CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Material Design Bootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.4/css/mdb.min.css"
	rel="stylesheet">

<!--   ---------CDN 모음 끝------------------------------------------  -->

<style>
@font-face {
	font-family: 'NanumbarunpenR';
	src: url('resources/fonts/nanumbarunpenr.ttf') format('truetype');
}

@font-face {
	font-family: 'NanumbarunpenB';
	src: url('resources/fonts/nanumbarunpenb.ttf') format('truetype');
}

body {
	font-family: 'NanumbarunpenR';
	margin: 0px;
}

nav {
	background-color: #1B0946;
	font-size: large;
}

#logo {
	width: 50px;
}

div {
	border: 1px solid black;
	box-sizing: border-box;
}

#wrapper {
	width: 100%;
}

#content {
	height: 100vh;
}

nav {
	background-color: #1B0946;
	font-size: large;
}

#logo {
	width: 50px;
}

#header {
	height: 150px;
}
</style>
<title>페이지 기본 틀2-게시판 형태용</title>
</head>

<body>
	<nav class="mb-1 navbar navbar-expand-lg navbar-dark"> <a
		class="navbar-brand" href="#"><img id="logo" alt=""
		src="resources/images/logo_white_no.png"></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent-3"
		aria-controls="navbarSupportedContent-3" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent-3">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="#">스타일 피드 <!-- <span class="sr-only">(current)</span> -->
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#">게시판</a></li>
		</ul>
		<ul class="navbar-nav ml-auto nav-flex-icons">
			<li class="nav-item"><a
				class="nav-link waves-effect waves-light"> <i
					class="fa fa-twitter"></i>알림
			</a></li>
			<li class="nav-item"><a
				class="nav-link waves-effect waves-light"> <i
					class="fa fa-google-plus"></i>메시지
			</a></li>
			<li class="nav-item"><a
				class="nav-link waves-effect waves-light"> <i
					class="fa fa-google-plus"></i>피드에 글쓰기
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdownMenuLink"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<i class="fa fa-user"></i>
			</a>
				<div class="dropdown-menu dropdown-menu-right dropdown-default"
					aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a> <a
						class="dropdown-item" href="#">Something else here</a>
				</div></li>
		</ul>
	</div>
	</nav>

	<div id="wrapper" class="container-fluid">
		<div class="row z-depth-1-half" id="header">
			<div class="col"></div>
			<div class="col"></div>
			<div class="col">
				<div class="row h-50">
					<div class="col">1</div>
					<div class="col">2</div>
					<div class="col">3</div>
					<div class="col">4</div>
				</div>
				<div class="row h-50">
					<div class="col">1</div>
					<div class="col">2</div>
					<div class="col">3</div>
					<div class="col">4</div>
				</div>
			</div>

		</div>
		<div class="row">
			<div class="col-md-12" id="content">내용1-메인</div>
		</div>

	</div>
</body>
<!-- JQuery -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/umd/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.5.4/js/mdb.min.js"></script>
</html>
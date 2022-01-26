<%@page import="model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MemberDTO info = (MemberDTO) session.getAttribute("info");
	String name = "로그인해주세요";
	if (info != null) {
		name = info.getNickname();
	} else {

	}
	%>
	<div>
		<form action="LoginService" method="post">
			ID:<input type="text" name="email" /> Password:<input type="text"
				name="pw" /> <br> <input type="submit" value="로그인"
				class="button fit">
		</form>
		<form action="JoinPage.jsp" method="post">
			<button>회원가입</button>

		</form>

		<span id=logincheck><%=name%></span>
	</div>
	<div id="map" style="width: 100%; height: 350px;"></div>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7f9afc13f88bb23b506a837d3e1517d9&libraries=services"></script>
	<script src="mapservice.js"></script>

	<select id="list" onchange="setCenter()">
		<option value="1">시내</option>
		<option value="2">학원</option>
		<option value="3">충장로</option>
	</select>

	<p>
		<em>지도를 클릭해주세요!</em>
	</p>
	<p id="result"></p>
	<p id="rsname"></p>

</body>
</html>
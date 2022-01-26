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
MemberDTO info=(MemberDTO)session.getAttribute("info");
String name="로그인해주세요";
if(info!=null){
	name=info.getNickname();
}else{
	
}

%>

	<form action="LoginService" method="post">
		ID:<input type="text" name="email" />
		 Password:<input type="text"
			name="pw" /> 
			<br>
			<input type="submit" value="로그인" class="button fit">
	</form>
	<form action="JoinPage.jsp" method="post">
		<button>회원가입</button>
	
	</form>
	<div>
	<span id=logincheck><%=name %></span>
	</div>

</body>
</html>
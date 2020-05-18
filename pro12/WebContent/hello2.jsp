<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%!
    	String name = "이순신";
    	public String getName() {return name;}
    %>
    <% String age = request.getParameter("age"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿 연습</title>
</head>
<body>
	<h1>안녕하세요 <%=name %>님!!</h1>
	<!-- 주소창에서 get방식으로 hello2.jsp?age="나이"를 기입할 경우 해당값만큼 age로 출력됨 -->
	<!-- 즉 JSP의 스크립트 요소는 먼저 브라우저로 전송되지 않고 컨테이너에서 자바 코드로 변환되는것을 알 수 있음 -->
	<h1>나이는 <%=age %>살 입니다!!</h1>
</body>
</html>
<%@ page import="game.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setCharacterEncoding("UTF-8");

    전투 전투객체 = (전투) session.getAttribute("전투객체");

    if (전투객체 == null) {
        전투객체 = new 전투();
        session.setAttribute("전투객체", 전투객체);
    }

    String 결과 = "";

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String 플레이어id = request.getParameter("플레이어id");

        결과 = 전투객체.몬스터공격(플레이어id);
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>몬스터 공격</title>
</head>
<body>
    <h2>몬스터 공격</h2>

    <form method="post">
        플레이어 ID: <input type="text" name="플레이어id"><br>

        <button type="submit">몬스터 공격</button>
    </form>

    <p><%= 결과 %></p>

    <hr>

    <form action="getItem.jsp" method="get">
        <button type="submit">아이템 획득으로 이동</button>
    </form>

    <form action="joinGuild.jsp" method="get">
        <button type="submit">길드 가입으로 이동</button>
    </form>

    <form action="createCharacter.jsp" method="get">
        <button type="submit">캐릭터 생성으로 이동</button>
    </form>
</body>
</html>
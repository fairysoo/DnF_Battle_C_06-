<%@ page import="game.전투" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setCharacterEncoding("UTF-8");

    String 결과메시지 = null;

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String 플레이어id = request.getParameter("플레이어id");

        전투 전투객체 = (전투) session.getAttribute("전투객체");

        if (전투객체 == null) {
            결과메시지 = "전투 객체가 없습니다. 먼저 캐릭터를 생성하세요.";
        } else {
            결과메시지 = 전투객체.몬스터공격(플레이어id);
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Attack_monster_UI</title>
</head>
<body>

<h2>Attack_monster_UI</h2>

<form action="attackMonster.jsp" method="post">
    <p>
        플레이어 ID:
        <input type="text" name="플레이어id">
    </p>

    <button type="submit">몬스터 공격</button>
</form>

<%
    if (결과메시지 != null) {
%>
    <hr>
    <p><%= 결과메시지 %></p>
<%
    }
%>

<br>
<a href="createCharacter.jsp">캐릭터 생성 화면으로 이동</a>

</body>
</html>
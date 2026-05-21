<%@ page import="game.전투" %>
<%@ page import="game.캐릭터" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>



<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create_Character_UI</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");

    String 결과메시지 = null;

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String 플레이어id = request.getParameter("플레이어id");
        String 캐릭터명 = request.getParameter("캐릭터명");
        String 레벨문자열 = request.getParameter("레벨");
        String 직업 = request.getParameter("직업");

        int 레벨 = Integer.parseInt(레벨문자열);

        전투 전투객체 = new 전투();

        전투객체.캐릭터생성(
            플레이어id,
            캐릭터명,
            레벨,
            직업
        );

        session.setAttribute("전투객체", 전투객체);

        결과메시지 = "캐릭터 생성 요청이 처리되었습니다.";
    }
%>

<h2>Create_Character_UI</h2>

<form action="createCharacter.jsp" method="post">
    <p>
        플레이어 ID:
        <input type="text" name="플레이어id">
    </p>

    <p>
        캐릭터명:
        <input type="text" name="캐릭터명">
    </p>

    <p>
        레벨:
        <input type="number" name="레벨">
    </p>

    <p>
        직업:
        <select name="직업">
            <option value="전사">전사</option>
            <option value="마법사">마법사</option>
        </select>
    </p>

    <button type="submit">캐릭터 생성</button>
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
<a href="attackMonster.jsp">몬스터 공격 화면으로 이동</a>

</body>
</html>
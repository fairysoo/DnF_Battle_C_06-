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
        String 아이템명 = request.getParameter("아이템명");
        String 아이템타입 = request.getParameter("아이템타입");
        int 아이템가치 = Integer.parseInt(request.getParameter("아이템가치"));

        결과 = 전투객체.아이템획득(플레이어id, 아이템명, 아이템타입, 아이템가치);
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>아이템 획득</title>
</head>
<body>
    <h2>아이템 획득</h2>

    <form method="post">
        플레이어 ID: <input type="text" name="플레이어id"><br>
        아이템명: <input type="text" name="아이템명"><br>
        아이템 타입:
        <select name="아이템타입">
            <option value="무기">무기</option>
            <option value="방어구">방어구</option>
            <option value="물약">물약</option>
        </select><br>
        아이템 가치: <input type="number" name="아이템가치"><br>

        <button type="submit">아이템 획득</button>
    </form>

    <p><%= 결과 %></p>
</body>
</html>
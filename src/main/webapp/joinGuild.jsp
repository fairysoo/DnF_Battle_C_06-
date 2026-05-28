<%@ page import="game.*" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    request.setCharacterEncoding("UTF-8");

    전투 전투객체 = (전투) session.getAttribute("전투객체");

    if (전투객체 == null) {
        전투객체 = new 전투();
        session.setAttribute("전투객체", 전투객체);
    }

    Map<String, 길드> 길드목록 = (Map<String, 길드>) session.getAttribute("길드목록");

    if (길드목록 == null) {
        길드목록 = new HashMap<>();

        길드목록.put("용사길드", new 길드("용사길드", 3));
        길드목록.put("마법길드", new 길드("마법길드", 3));
        길드목록.put("초보자길드", new 길드("초보자길드", 3));

        session.setAttribute("길드목록", 길드목록);
    }

    String 결과 = "";

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String 플레이어id = request.getParameter("플레이어id");
        String 길드명 = request.getParameter("길드명");

        길드 선택길드 = 길드목록.get(길드명);

        if (!전투객체.플레이어체크(플레이어id)) {
            결과 = "플레이어 아이디가 일치하지 않습니다.";
        } else if (전투객체.get캐릭터() == null) {
            결과 = "생성된 캐릭터가 없습니다.";
        } else if (선택길드 == null) {
            결과 = "존재하지 않는 길드입니다.";
        } else {
            boolean 가입결과 = 선택길드.길드가입(전투객체.get캐릭터());

            if (가입결과) {
                결과 = 전투객체.get캐릭터().캐릭터명 + "이(가) " + 선택길드.길드명 + " 길드에 가입했습니다.";
            } else {
                결과 = "길드 정원이 가득 차서 가입할 수 없습니다.";
            }
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>길드 가입</title>
</head>
<body>
    <h2>길드 가입</h2>

    <form method="post">
        플레이어 ID: <input type="text" name="플레이어id"><br>
        길드명:
        <select name="길드명">
            <option value="용사길드">용사길드</option>
            <option value="마법길드">마법길드</option>
            <option value="초보자길드">초보자길드</option>
        </select><br>

        <button type="submit">길드 가입</button>
    </form>

    <p><%= 결과 %></p>
</body>
</html>
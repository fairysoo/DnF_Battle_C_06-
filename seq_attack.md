```mermaid
sequenceDiagram
    actor 사용자 as 플레이어
    participant UI as Attack_Monster_UI
    participant Battle as 전투
    participant Player as 플레이어
    participant Character as 캐릭터

    사용자->>UI: 선택_몬스터공격(플레이어id)
    activate UI

    UI->>Battle: 몬스터공격(플레이어id)
    activate Battle

    Battle->>Player: 플레이어체크(플레이어id)
    activate Player
    Player-->>Battle: boolean 반환
    deactivate Player

    alt 플레이어체크 실패 (false)
        Battle-->>UI: "플레이어 아이디가 일치하지 않습니다." 반환
    else 플레이어체크 성공 (true)
        Battle->>Character: 스킬발동()
        activate Character
        Character-->>Battle: 데미지 int 반환
        deactivate Character

        alt 데미지 >= 200
            Battle->>Battle: 등급 = "S"
        else 데미지 >= 100
            Battle->>Battle: 등급 = "A"
        else 데미지 < 100
            Battle->>Battle: 등급 = "B"
        end

        Battle-->>UI: 결과 문자열 반환
    end

    deactivate Battle

    UI-->>사용자: 결과 화면 출력
    deactivate UI
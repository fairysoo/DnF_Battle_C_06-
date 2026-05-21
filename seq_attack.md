```mermaid
sequenceDiagram
    actor 사용자 as 플레이어
    participant UI as Attack_Monster_UI
    participant Battle as 전투
    participant Player as 플레이어
    participant Character as 캐릭터

    사용자->>UI: 선택_몬스터공격(플레이어id)
    UI->>Battle: 몬스터공격(플레이어id)

    Battle->>Player: 플레이어체크(플레이어id)
    Player-->>Battle: boolean 반환

    alt 플레이어체크 실패 (false)
        Battle-->>UI: null 반환 (플레이어 아이디가 일치하지 않습니다 출력)
    else 플레이어체크 성공 (true)
        Battle->>Character: 스킬발동()
        
        alt 데미지 >= 200
            Character->>Character: 등급 = "S"
        else 데미지 >= 100
            Character->>Character: 등급 = "A"
        else 데미지 < 100
            Character->>Character: 등급 = "B"
        end

        Character-->>Battle: 결과 문자열 반환 (데미지 및 등급 포함)
        Battle-->>UI: 결과 문자열 반환
    end
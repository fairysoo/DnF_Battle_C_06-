```mermaid
sequenceDiagram
    actor 사용자 as 플레이어
    participant UI as Create_Character_UI
    participant Battle as 전투
    participant Player as 플레이어
    participant Warrior as 전사
    participant Mage as 마법사

    사용자->>UI: 입력_플레이어ID(플레이어id)
    사용자->>UI: 입력_캐릭터정보(캐릭터명, 직업, 레벨)

    UI->>Battle: 캐릭터생성(플레이어id, 캐릭터명, 레벨, 직업)

    Battle->>Player: 플레이어체크(플레이어id)
    Player-->>Battle: boolean 반환

    alt 플레이어체크 실패 (false)
        Battle-->>UI: 플레이어 아이디가 일치하지 않습니다 출력
    else 플레이어체크 성공 (true)
        alt 직업이 전사
            Battle->>Warrior: new 전사(캐릭터명, 레벨)
            Battle-->>UI: 캐릭터생성 완료
        else 직업이 마법사
            Battle->>Mage: new 마법사(캐릭터명, 레벨)
            Battle-->>UI: 캐릭터생성 완료
        else 직업 오류
            Battle-->>UI: 존재하지 않는 직업입니다 출력
        end
    end
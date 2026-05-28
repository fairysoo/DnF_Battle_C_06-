```mermaid
sequenceDiagram
    actor 사용자 as 플레이어
    participant UI as Add_Item_UI
    participant Battle as 전투
    participant Player as 플레이어
    participant Item as 아이템
    participant Character as 캐릭터
    participant Inv as 인벤토리

    사용자->>UI: 선택_아이템획득(id, 명, 타입, 가치)
    UI->>Battle: 아이템획득(플레이어id, 아이템명, 아이템타입, 아이템가치)

    Battle->>Player: 플레이어체크(플레이어id)
    Player-->>Battle: boolean 반환

    alt 플레이어체크 실패 (false)
        Battle-->>UI: "플레이어 아이디가 일치하지 않습니다." 반환
    else 플레이어체크 성공 (true)
        alt 캐릭터 == null
            Battle-->>UI: "생성된 캐릭터가 없습니다." 반환
        else 캐릭터 존재
            alt 타입 검증 실패 (무기/방어구/물약 아님)
                Battle-->>UI: "아이템 타입은 무기, 방어구, 물약만 가능합니다." 반환
            else 타입 검증 성공
                Battle->>Item: 생성자 호출 (new 아이템)
                Item->>Item: 등급부여()
                Item-->>Battle: 아이템 객체 생성 완료
                
                Battle->>Character: 인벤토리 접근
                Character-->>Battle: 인벤토리 객체 주소 반환
                
                Battle->>Inv: 아이템추가(아이템)
                Inv->>Inv: 인벤토리확인()
                
                alt 인벤토리 가득 참 (false)
                    Inv-->>Battle: false 반환
                    Battle-->>UI: "인벤토리가 가득 차서 아이템을 획득할 수 없습니다." 반환
                else 인벤토리 공간 있음 (true)
                    Inv-->>Battle: true 반환
                    Battle-->>UI: 아이템명 + " 아이템을 획득했습니다. 등급: " + 등급 반환
                end
            end
        end
    end
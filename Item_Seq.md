sequenceDiagram
    actor 사용자 as 플레이어
    participant UI as Add_Item_UI
    participant Battle as 전투
    participant Player as 플레이어
    participant Item as 아이템
    participant Inv as 인벤토리

    activate 사용자
    사용자->>UI: 선택_아이템획득(id, 명, 타입, 가치)
    activate UI
    UI->>Battle: 아이템획득(플레이어id, 아이템명, 아이템타입, 아이템가치)
    activate Battle

    Battle->>Player: 플레이어체크(플레이어id)
    activate Player
    Player-->>Battle: boolean 반환
    deactivate Player

    alt 플레이어체크 실패 (false)
        Battle-->>UI: "플레이어 아이디가 일치하지 않습니다." 반환
    else 플레이어체크 성공 (true)
        
        alt 캐릭터 == null
            Battle-->>UI: "생성된 캐릭터가 없습니다." 반환
        else 캐릭터 존재
            
            alt 타입 검증 실패
                Battle-->>UI: "아이템 타입은 무기, 방어구, 물약만 가능합니다." 반환
            else 타입 검증 성공
                
                Battle->>Item: 생성자 호출(아이템명, 아이템타입, 아이템가치)
                activate Item
                Item->>Item: 등급부여()
                Item-->>Battle: 아이템 객체 반환
                deactivate Item
                
                Battle->>Inv: 아이템추가(아이템)
                activate Inv
                Inv->>Inv: 인벤토리확인()
                Inv-->>Battle: boolean 반환
                deactivate Inv
                
                alt 추가결과 == false
                    Battle-->>UI: "인벤토리가 가득 차서 아이템을 획득할 수 없습니다." 반환
                else 추가결과 == true
                    Battle-->>UI: 아이템명 + " 아이템을 획득했습니다. 등급: " + 아이템등급 반환
                end
            end
        end
    end
    deactivate Battle
    deactivate UI
    deactivate 사용자

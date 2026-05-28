```mermaid
sequenceDiagram
    actor User as 플레이어
    participant UI as Join_Guild_UI
    participant GuildMap as 길드목록
    participant Battle as 전투
    participant Player as 플레이어객체
    participant Character as 캐릭터
    participant Guild as 길드

    User->>UI: 입력_길드가입정보(플레이어id, 길드명)
    activate UI

    UI->>GuildMap: get(길드명)
    activate GuildMap
    GuildMap-->>UI: 선택길드 반환
    deactivate GuildMap

    alt 선택길드가 존재하지 않음
        UI-->>User: 존재하지 않는 길드입니다 출력
    else 선택길드가 존재함
        UI->>Battle: 플레이어체크(플레이어id)
        activate Battle

        Battle->>Player: 플레이어체크(플레이어id)
        activate Player
        Player-->>Battle: boolean 반환
        deactivate Player

        Battle-->>UI: boolean 반환
        deactivate Battle

        alt 플레이어체크 실패
            UI-->>User: 플레이어 아이디가 일치하지 않습니다 출력
        else 플레이어체크 성공
            UI->>Battle: get캐릭터()
            activate Battle
            Battle-->>UI: 캐릭터 반환
            deactivate Battle

            alt 캐릭터가 존재하지 않음
                UI-->>User: 생성된 캐릭터가 없습니다 출력
            else 캐릭터가 존재함
                UI->>Guild: 길드가입(캐릭터)
                activate Guild

                Guild->>Guild: 정원확인()

                alt 길드 정원이 가득 참
                    Guild-->>UI: false 반환
                    UI-->>User: 길드 정원이 가득 차서 가입할 수 없습니다 출력
                else 길드 정원에 여유 있음
                    Guild->>Guild: 길드원목록에 캐릭터 추가

                    Guild->>Character: 가입길드 설정
                    activate Character
                    Character-->>Guild: 설정 완료
                    deactivate Character

                    Guild-->>UI: true 반환
                    UI-->>User: 길드 가입 완료 출력
                end

                deactivate Guild
            end
        end
    end

    deactivate UI
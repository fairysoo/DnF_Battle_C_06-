```mermaid
graph LR
    subgraph "던전앤파이터 전투 시스템"
        CreateChar["캐릭터생성"]
        AttackMonster["몬스터공격"]
        AcquireItem["아이템획득"]
        JoinGuild["길드가입"]
        CheckPlayer["플레이어체크"]
    end

    Player["플레이어"]

    Player --- CreateChar
    Player --- AttackMonster
    Player --- AcquireItem
    Player --- JoinGuild

    CreateChar -.->|"<<include>>"| CheckPlayer
    AttackMonster -.->|"<<include>>"| CheckPlayer
    AcquireItem -.->|"<<include>>"| CheckPlayer
    JoinGuild -.->|"<<include>>"| CheckPlayer

```mermaid
graph LR
    subgraph "던전앤파이터 전투 시스템"
        CreateChar["캐릭터생성"]
        AttackMonster["몬스터공격"]
        CheckPlayer["플레이어체크"]
    end

    Player["플레이어"]

    Player --- CreateChar
    Player --- AttackMonster

    CreateChar -.->|"&lt;&lt;include&gt;&gt;"| CheckPlayer
    AttackMonster -.->|"&lt;&lt;include&gt;&gt;"| CheckPlayer
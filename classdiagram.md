```mermaid
classDiagram
    class Create_Character_UI {
        <<boundary>>
        +입력_플레이어ID(플레이어id)
        +입력_캐릭터정보(캐릭터명, 직업, 레벨)
    }

    class Attack_Monster_UI {
        <<boundary>>
        +선택_몬스터공격(플레이어id)
    }

    class 플레이어 {
        -id: String = "hero"
        +플레이어체크(playerid: String) boolean
    }

    class 전투 {
        +플레이어: 플레이어
        +캐릭터: 캐릭터
        +전투()
        +캐릭터생성(플레이어id: String, 캐릭터명: String, 레벨: int, 직업: String) boolean
        +몬스터공격(플레이어id: String) String
    }

    class 캐릭터 {
        <<abstract>>
        +캐릭터명: String
        +레벨: int
        +hp: int
        +공격력: int
        +스킬발동()* String
    }

    class 전사 {
        +전사(캐릭터명: String, 레벨: int)
        +스킬발동() String
    }

    class 마법사 {
        +마법사(캐릭터명: String, 레벨: int)
        +스킬발동() String
    }

    캐릭터 <|-- 전사
    캐릭터 <|-- 마법사

    전투 "1" --> "1" 플레이어 : 가짐
    전투 "1" --> "0..1" 캐릭터 : 가짐

    Create_Character_UI ..> 전투 : 사용
    Attack_Monster_UI ..> 전투 : 사용
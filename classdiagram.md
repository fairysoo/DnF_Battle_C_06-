```mermaid
classDiagram
    class Create_Character_UI {
        <<boundary>>
        +세션_전투객체조회() 전투
        +입력_플레이어ID(플레이어id)
        +입력_캐릭터정보(캐릭터명, 직업, 레벨)
        +캐릭터생성요청(플레이어id, 캐릭터명, 직업, 레벨)
    }

    class Attack_Monster_UI {
        <<boundary>>
        +세션_전투객체조회() 전투
        +선택_몬스터공격(플레이어id)
        +이동_아이템획득()
        +이동_길드가입()
        +이동_캐릭터생성()
    }

    class Get_Item_UI {
        <<boundary>>
        +세션_전투객체조회() 전투
        +입력_아이템획득정보(플레이어id, 아이템명, 아이템타입, 아이템가치)
        +아이템획득요청(플레이어id, 아이템명, 아이템타입, 아이템가치)
    }

    class Join_Guild_UI {
        <<boundary>>
        +세션_전투객체조회() 전투
        +세션_길드목록조회() Map~String, 길드~
        +세션_길드조회(길드명) 길드
        +입력_길드가입정보(플레이어id, 길드명)
        +길드가입요청(플레이어id, 길드명)
    }

    class 플레이어 {
        -id: String = "hero"
        +플레이어체크(playerid: String) boolean
    }

    class 전투 {
        -플레이어: 플레이어
        -캐릭터: 캐릭터
        +전투()
        +캐릭터생성(플레이어id: String, 캐릭터명: String, 레벨: int, 직업: String) boolean
        +몬스터공격(플레이어id: String) String
        +아이템획득(플레이어id: String, 아이템명: String, 아이템타입: String, 아이템가치: int) String
        +길드가입(플레이어id: String, 길드: 길드) String
        +get캐릭터() 캐릭터
    }

    class 캐릭터 {
        <<abstract>>
        +캐릭터명: String
        +레벨: int
        +hp: int
        +공격력: int
        +인벤토리: 인벤토리
        +가입길드: 길드
        +스킬발동()* int
    }

    class 전사 {
        +전사(캐릭터명: String, 레벨: int)
        +스킬발동() int
    }

    class 마법사 {
        +마법사(캐릭터명: String, 레벨: int)
        +스킬발동() int
    }

    class 인벤토리 {
        -아이템목록: List~아이템~
        -최대개수: int = 10
        +아이템추가(아이템: 아이템) boolean
        +인벤토리확인() boolean
        +get아이템목록() List~아이템~
        +get최대개수() int
    }

    class 아이템 {
        +아이템명: String
        +아이템타입: String
        +아이템가치: int
        +아이템등급: String
        +아이템(아이템명: String, 아이템타입: String, 아이템가치: int)
        +등급부여() String
    }

    class 길드 {
        +길드명: String
        -길드원목록: List~캐릭터~
        -최대정원: int
        +길드(길드명: String, 최대정원: int)
        +길드가입(캐릭터: 캐릭터) boolean
        +정원확인() boolean
        +get길드원목록() List~캐릭터~
        +get최대정원() int
    }

    캐릭터 <|-- 전사
    캐릭터 <|-- 마법사

    전투 "1" --> "1" 플레이어 : 가짐
    전투 "1" --> "0..1" 캐릭터 : 가짐

    캐릭터 "1" *-- "1" 인벤토리 : 가짐
    인벤토리 "1" *-- "0..10" 아이템 : 포함

    길드 "1" o-- "0..*" 캐릭터 : 가입

    Create_Character_UI ..> 전투 : 세션 전투객체 사용
    Attack_Monster_UI ..> 전투 : 세션 전투객체 사용
    Get_Item_UI ..> 전투 : 세션 전투객체 사용
    Join_Guild_UI ..> 전투 : 세션 전투객체 사용

    Join_Guild_UI ..> 길드 : 세션 길드 조회
package game;

public abstract class 캐릭터 {
    public String 캐릭터명;
    public int 레벨;
    public int hp;
    public int 공격력;
    public 인벤토리 인벤토리;
    public 길드 가입길드;

    public 캐릭터(String 캐릭터명, int 레벨) {
        this.캐릭터명 = 캐릭터명;
        this.레벨 = 레벨;
        this.인벤토리 = new 인벤토리();
    }

    public abstract int 스킬발동();
}
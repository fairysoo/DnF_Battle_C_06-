package game;

public abstract class 캐릭터 {
    public String 캐릭터명;
    public int 레벨;
    public int hp;
    public int 공격력;

    public abstract int 스킬발동();
}
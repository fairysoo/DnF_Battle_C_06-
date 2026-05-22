package game;


public class 마법사 extends 캐릭터 {

	public 마법사(String 캐릭터명, int 레벨) {
		
		this.캐릭터명 = 캐릭터명;
		this.레벨 = 레벨;
		this.hp = 레벨 * 60;
		this.공격력 = 레벨 * 25;
		
	}
	
    @Override
    public int 스킬발동() {
    	return (int)(공격력 * 2.0);
    }
}
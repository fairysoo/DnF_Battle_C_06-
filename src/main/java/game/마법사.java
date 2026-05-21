package game;


public class 마법사 extends 캐릭터 {

	public 마법사(String 캐릭터명, int 레벨) {
		
		this.캐릭터명 = 캐릭터명;
		this.레벨 = 레벨;
		this.hp = 레벨 * 60;
		this.공격력 = 레벨 * 25;
		
	}
	
    @Override
    public String 스킬발동() {
    	String 등급 = "";
    	float 데미지 = (int)(공격력 * 2.0);
    	if(데미지 >= 200) 등급 = "S";
    	else if(데미지 >= 100) 등급 = "A";
    	else 등급 = "B";
    	
        return "파이어볼! : " + 데미지 + "의 피해를 입힙니다! \n " + "공격 등급 : " + 등급;
    }
}
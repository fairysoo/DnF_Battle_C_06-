package game;


public class 마법사 extends 캐릭터 {
	플레이어 플레이어;

	public 마법사(String 플레이어id, String 캐릭터명, int 레벨) {
		플레이어 = new 플레이어();
		if(!플레이어.플레이어체크(플레이어id) ) {
			System.out.println("플레이어 아이디가 일치하지 않습니다.");
			return;
		}
		
		this.캐릭터명 = 캐릭터명;
		this.레벨 = 레벨;
		this.hp = 레벨 * 60;
		this.공격력 = 레벨 * 25;
		
	}
	
    @Override
    public String 스킬발동() {
    	String 등급 = "";
    	float 데미지 = (int)(공격력 * 1.5);
    	if(데미지 >= 200) 등급 = "S";
    	else if(데미지 >= 100) 등급 = "A";
    	else 등급 = "B";
    	
        return "파이어볼! : " + 데미지 + "의 피해를 입힙니다! \n " + "공격 등급 : " + 등급;
    }
}
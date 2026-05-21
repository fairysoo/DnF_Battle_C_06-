package game;

public class 전투 {
	
	플레이어 플레이어;
	캐릭터 캐릭터;
	
	public 전투() {
		플레이어 = new 플레이어();
	}

    public boolean 캐릭터생성(String 플레이어id, String 캐릭터명, int 레벨, String 직업) {
    	if(플레이어.플레이어체크(플레이어id) == false) {
			System.out.println("플레이어 아이디가 일치하지 않습니다.");
			return false;
		}
    	
    	if(직업.equals("전사")) {
			캐릭터 = new 전사(캐릭터명, 레벨);
		} else if(직업.equals("마법사")) {
			캐릭터 = new 마법사(캐릭터명, 레벨);
		} else {
			System.out.println("존재하지 않는 직업입니다.");
		}
    	return true;
    }

    public String 몬스터공격(String 플레이어id) {
    	if(플레이어.플레이어체크(플레이어id) == false) {
			return ("플레이어 아이디가 일치하지 않습니다.");
		}
    	
    	return 캐릭터.스킬발동();
    }
}
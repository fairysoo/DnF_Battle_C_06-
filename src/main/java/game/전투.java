package game;

public class 전투 {
	
	private 플레이어 플레이어;
	private 캐릭터 캐릭터;
	
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
    	
    	int 데미지 = 캐릭터.스킬발동();
    	String 등급 = "";
    	if(데미지 >= 200) 등급 = "S";
    	else if(데미지 >= 100) 등급 = "A";
    	else 등급 = "B";
    	
        return "파이어볼! : " + 데미지 + "의 피해를 입힙니다! \n " + "공격 등급 : " + 등급;
    }
    
    public String 아이템획득(String 플레이어id, String 아이템명, String 아이템타입, int 아이템가치) {
        if (!플레이어.플레이어체크(플레이어id)) {
            return "플레이어 아이디가 일치하지 않습니다.";
        }

        if (캐릭터 == null) {
            return "생성된 캐릭터가 없습니다.";
        }

        if (!"무기".equals(아이템타입) && !"방어구".equals(아이템타입) && !"물약".equals(아이템타입)) {
            return "아이템 타입은 무기, 방어구, 물약만 가능합니다.";
        }

        아이템 아이템 = new 아이템(아이템명, 아이템타입, 아이템가치);

        boolean 추가결과 = 캐릭터.인벤토리.아이템추가(아이템);

        if (!추가결과) {
            return "인벤토리가 가득 차서 아이템을 획득할 수 없습니다.";
        }

        return 아이템.아이템명 + " 아이템을 획득했습니다. 등급: " + 아이템.아이템등급;
    }

    public String 길드가입(String 플레이어id, 길드 길드) {
        if (!플레이어.플레이어체크(플레이어id)) {
            return "플레이어 아이디가 일치하지 않습니다.";
        }

        if (캐릭터 == null) {
            return "생성된 캐릭터가 없습니다.";
        }

        if (길드 == null) {
            return "존재하지 않는 길드입니다.";
        }

        boolean 가입결과 = 길드.길드가입(캐릭터);

        if (!가입결과) {
            return "길드 정원이 가득 차서 가입할 수 없습니다.";
        }

        return 캐릭터.캐릭터명 + "이(가) " + 길드.길드명 + " 길드에 가입했습니다.";
    }
    
    public boolean 플레이어체크(String 플레이어id) {
        return 플레이어.플레이어체크(플레이어id);
    }

    public 캐릭터 get캐릭터() {
        return 캐릭터;
    }
}
package game;

public class 플레이어 {
	
	private String id = "hero";

    public boolean 플레이어체크(String playerid) {
        return playerid.equals(id);
    }
}
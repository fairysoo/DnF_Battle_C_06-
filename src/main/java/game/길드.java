package game;

import java.util.ArrayList;
import java.util.List;

public class 길드 {
    public String 길드명;
    private List<캐릭터> 길드원목록 = new ArrayList<>();
    private int 최대정원;

    public 길드(String 길드명, int 최대정원) {
        this.길드명 = 길드명;
        this.최대정원 = 최대정원;
    }

    public boolean 길드가입(캐릭터 캐릭터) {
        if (!정원확인()) {
            return false;
        }

        길드원목록.add(캐릭터);
        캐릭터.가입길드 = this;
        return true;
    }

    public boolean 정원확인() {
        return 길드원목록.size() < 최대정원;
    }

    public List<캐릭터> get길드원목록() {
        return 길드원목록;
    }

    public int get최대정원() {
        return 최대정원;
    }
}
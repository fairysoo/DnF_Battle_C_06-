package game;

import java.util.ArrayList;
import java.util.List;

public class 인벤토리 {
    private List<아이템> 아이템목록 = new ArrayList<>();
    private int 최대개수 = 10;

    public boolean 아이템추가(아이템 아이템) {
        if (!인벤토리확인()) {
            return false;
        }

        아이템목록.add(아이템);
        return true;
    }

    public boolean 인벤토리확인() {
        return 아이템목록.size() < 최대개수;
    }

    public List<아이템> get아이템목록() {
        return 아이템목록;
    }

    public int get최대개수() {
        return 최대개수;
    }
}
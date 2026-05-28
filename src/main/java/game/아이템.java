package game;

public class 아이템 {
    public String 아이템명;
    public String 아이템타입;
    public int 아이템가치;
    public String 아이템등급;

    public 아이템(String 아이템명, String 아이템타입, int 아이템가치) {
        this.아이템명 = 아이템명;
        this.아이템타입 = 아이템타입;
        this.아이템가치 = 아이템가치;
        this.아이템등급 = 등급부여();
    }

    public String 등급부여() {
        if (아이템가치 >= 1000) {
            return "전설";
        } else if (아이템가치 >= 500) {
            return "희귀";
        } else {
            return "일반";
        }
    }
}
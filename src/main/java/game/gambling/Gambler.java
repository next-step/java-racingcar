package game.gambling;

/**
 * Created by yusik on 2019/10/29.
 */
public class Gambler {

    private String name;
    private int card;

    public Gambler(String name, int card) {
        this.name = name;
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public int getCard() {
        return card;
    }
}

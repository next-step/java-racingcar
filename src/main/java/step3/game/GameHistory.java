package step3.game;

public class GameHistory {
    private String name;
    private int position;
    public GameHistory(String name, int position) {
        this.name = name;
        this.position = position;
    }
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}

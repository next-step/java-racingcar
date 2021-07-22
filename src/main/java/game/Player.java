package game;

public class Player {

    private String playerName;
    private int raceDistance;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public int playToMove(int value) {
        return value > 3 ? ++raceDistance : raceDistance;
    }
}

package game;

public class Player {

    private final String playerName;
    private int raceDistance;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public int playToMove(int value) {
        return value > 3 ? ++raceDistance : raceDistance;
    }

    public String getPlayerName(){
        return playerName;
    }

}

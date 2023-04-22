package race.step4.model;

public class InputData {
    private String[] players;
    private int numTry;

    public InputData(String[] players, int numTry) {
        this.players = players;
        this.numTry = numTry;
    }

    public String[] getPlayers() {
        return players;
    }

    public int getNumTry() {
        return numTry;
    }
}

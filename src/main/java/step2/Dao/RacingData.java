package step2.Dao;

public class RacingData {
    private String[] carsName;
    private int turn;

    public RacingData(String[] carsName, int turn) {
        this.carsName = carsName;
        this.turn = turn;
    }

    public String[] getCarsName() {
        return carsName;
    }

    public int getTurn() {
        return turn;
    }
}

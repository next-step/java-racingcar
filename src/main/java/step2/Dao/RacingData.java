package step2.Dao;

public class RacingData {
    private String[] carsName;
    private int turn;

    public RacingData(String[] carsName, int turn) {
        this.carsName = carsName;
        this.turn = turn;
    }

    public String[] getCarsName() {
        return this.carsName;
    }

    public int getTurn() {
        return this.turn;
    }
}

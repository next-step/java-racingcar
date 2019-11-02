package step2.Dao;

public class RacingData {
    private String[] carModels;
    private int turn;

    public RacingData(String[] carModels, int turn) {
        this.carModels = carModels;
        this.turn = turn;
    }

    public String[] getCarModels() {
        return carModels;
    }

    public int getTurn() {
        return turn;
    }
}

package step2.dto;

public class RacingData {
    private String[] carModels;
    private int round;

    public RacingData(String[] carModels, int round) {
        this.carModels = carModels;
        this.round = round;
    }

    public String[] getCarModels() {
        return carModels;
    }

    public int getRound() {
        return round;
    }
}

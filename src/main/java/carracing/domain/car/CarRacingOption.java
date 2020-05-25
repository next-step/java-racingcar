package carracing.domain;

public class CarRacingOption {

    private int carCount;
    private int gameCount;
    private String[] carNames;

    public CarRacingOption() {}

    public CarRacingOption(String [] carNames, int carCount, int gameCount) {
        this.carCount = carCount;
        this.gameCount = gameCount;
        this.carNames = carNames;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getGameCount() {
        return gameCount;
    }

    public String[] getCarNames() {
        return carNames;
    }
}

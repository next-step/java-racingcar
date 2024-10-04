package racinggame.domain;

public class GameResult {
    private final String carName;
    private final int carPosition;

    public GameResult(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }
}

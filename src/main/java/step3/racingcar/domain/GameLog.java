package step3.racingcar.domain;

public class GameLog {

    private String carName;
    private int carPosition;

    public GameLog(String carName, int carPosition) {
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

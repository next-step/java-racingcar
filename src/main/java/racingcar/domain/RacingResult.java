package racingcar.domain;

public class RacingResult {

    final String carName;
    final int movingDistance;

    public RacingResult(String carName, int movingDistance) {
        this.carName = carName;
        this.movingDistance = movingDistance;
    }

    public String getCarName() {
        return carName;
    }

    public int getMovingDistance() {
        return movingDistance;
    }
}

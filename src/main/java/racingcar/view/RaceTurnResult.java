package racingcar.view;

public class RaceTurnResult {

    private String carName;
    private String distance;

    public RaceTurnResult(String carName, String distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public String getCarName() {
        return carName;
    }

    public String getDistance() {
        return distance;
    }
}

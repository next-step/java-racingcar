package racingcar.domain;

public class RacingResult {
    private String name;
    private int distance;

    public RacingResult(RacingCar car) {
        this.name = car.getName();
        this.distance = car.getDistance();
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}

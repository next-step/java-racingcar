package racingcar.domain;

public class RacingResult {
    private String name;
    private int position;

    public RacingResult(RacingCar car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

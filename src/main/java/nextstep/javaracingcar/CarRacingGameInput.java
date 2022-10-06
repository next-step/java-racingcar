package nextstep.javaracingcar;

public class CarRacingGameInput {

    private final PositiveNumber carCount;
    private final Round round;

    public CarRacingGameInput(int carCount, int roundCount) {
        this.carCount = PositiveNumber.from(carCount);
        this.round = new Round(roundCount);
    }

    public PositiveNumber carCount() {
        return carCount;
    }

    public Round round() {
        return round;
    }
}

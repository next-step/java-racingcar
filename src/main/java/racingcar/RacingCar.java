package racingcar;

public class RacingCar extends Car {
    private Integer lane;

    protected RacingCar() {
    }

    public RacingCar(int lane) {
        this.lane = lane;
    }
}

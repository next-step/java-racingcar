package step3_racing_car.domain;

public class Winners {
    RacingCars racingCars;

    public Winners(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars findWinners() {
        int maxPosition = this.racingCars.maxPositionValue();
        return new RacingCars(this.racingCars.matchPositionList(maxPosition));
    }
}

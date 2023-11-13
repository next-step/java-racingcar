package step3.domain;

public class RacingGame {

    private NumberGenerator numberGenerator;

    private RacingCar[] racingCars;

    public RacingGame(RacingCar[] racingCars, NumberGenerator numberGenerator) {
        this.racingCars = racingCars;
        this.numberGenerator = numberGenerator;
    }

    public RacingCar[] runRound() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(numberGenerator);
        }
        return getRacingCarsStatus();
    }

    public RacingCar[] getRacingCarsStatus() {
        return racingCars;
    }

}

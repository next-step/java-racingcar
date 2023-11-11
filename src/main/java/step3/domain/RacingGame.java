package step3.domain;

public class RacingGame {

    private NumberGenerator numberGenerator;

    private RacingCar[] racingCars;

    public RacingGame(int carCount, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        initRacingCars(carCount);
    }

    public RacingCar[] runRound() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(numberGenerator.generate());
        }
        return getRacingCarsStatus();
    }

    public RacingCar[] getRacingCarsStatus() {
        return racingCars;
    }

    private void initRacingCars(int carCount) {
        this.racingCars = new RacingCar[carCount];
        for (int carNo = 0; carNo < carCount; carNo++) {
            racingCars[carNo] = new RacingCar();
        }
    }
}

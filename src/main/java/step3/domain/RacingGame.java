package step3.domain;

public class RacingGame {

    private static NumberGenerator numberGenerator = new RandomNumberGenerator();

    private RacingCar[] racingCars;

    public RacingGame(int carCount) {
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

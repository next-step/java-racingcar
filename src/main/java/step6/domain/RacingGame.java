package step6.domain;

public class RacingGame {
    private final Cars cars;
    private final TryNumber tryNumber;

    public RacingGame(Cars cars, TryNumber tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public void Run() {
        cars.runRacingGame(tryNumber);
    }
}

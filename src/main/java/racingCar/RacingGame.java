package racingCar;

public class RacingGame {
    //    private final int numOfCars;
    private final RacingCars cars;
    private final int numOfRounds;

    public RacingGame(RacingCars cars, int numOfRounds) {
        this.cars = cars;
        this.numOfRounds = numOfRounds;
    }

    public void start() {
        for (int i = 0; i < numOfRounds; i++) {
            cars.racing();
        }
    }
}

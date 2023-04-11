package step3;

public class RacingTrack {

    private final RacingOption racingOption;
    private final Cars cars;

    private RacingTrack(RacingOption racingOption, Cars cars) {
        this.racingOption = racingOption;
        this.cars = cars;
    }

    public static RacingTrack of(RacingOption racingOption) {
        Cars cars = Cars.of(racingOption.getNumberOfCars());
        return new RacingTrack(racingOption, cars);
    }

    public void start() {
        int rounds = racingOption.getNumberOfRounds();
        for (int i = 0; i < rounds; i++) {
            cars.move();
        }
    }

    public Cars getCars() {
        return cars;
    }
}

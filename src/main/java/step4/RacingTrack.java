package step4;

public class RacingTrack {

    private final Cars cars;

    private RacingTrack(Cars cars) {
        this.cars = cars;
    }

    public static RacingTrack of(RacingOption racingOption) {
        Cars cars = Cars.of(racingOption.getNumberGenerator(), racingOption.getNames());
        return new RacingTrack(cars);
    }

    public RacingGameResult start() {
        cars.move();
        return RacingGameResult.makeResult(cars);
    }
}

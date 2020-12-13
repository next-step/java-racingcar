package racingcar.domain;

public class RacingCar {
    private final Cars cars;
    private final Count count;
    private final RacingResult racingResult = new RacingResult();

    public RacingCar(Cars cars, Count count) {
        this.cars = cars;
        this.count = count;
    }

    public void start() {
        for (int i = 0; i < count.getCount(); i++) {
            cars.run();
            racingResult.report(cars.getCars());
        }

    }

    public RacingResult getRacingResult() {
        return this.racingResult;
    }
}

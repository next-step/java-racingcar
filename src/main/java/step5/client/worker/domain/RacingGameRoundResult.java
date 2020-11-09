package step5.client.worker.domain;


import java.util.List;

public class RacingGameRoundResult {
    private final List<Car> cars;

    private RacingGameRoundResult(final List<Car> cars) {
        this.cars = cars;
    }

    public static RacingGameRoundResult of(final List<Car> carRacingResults) {
        return new RacingGameRoundResult(carRacingResults);
    }

    public List<Car> getCars() {
        return cars;
    }
}

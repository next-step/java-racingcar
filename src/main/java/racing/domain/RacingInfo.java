package racing.domain;

import java.util.List;

public class RacingInfo {

    private final List<Car> cars;
    private final Round round;

    public RacingInfo(List<Car> cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public static RacingInfo of(String carNames, int roundNumber) {
        final List<Car> cars = CarGenerator.createCars(carNames);
        Round round = new Round(roundNumber);
        return new RacingInfo(cars, round);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Round getRound() {
        return round;
    }
}

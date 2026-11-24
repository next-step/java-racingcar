package racinggame.mvc.domain;

import java.util.List;

public class RacingResult {

    private final List<Car> cars;
    private final List<Car> winners;

    public RacingResult(List<Car> cars, List<Car> winners) {
        this.cars = cars;
        this.winners = winners;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        return winners;
    }
}

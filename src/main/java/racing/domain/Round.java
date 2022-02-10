package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private final int roundNumber;

    public Round(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public List<CarResult> play(List<Car> cars) {
        List<CarResult> results = new ArrayList<>();

        for (Car car : cars) {
            car.move();
            results.add(new CarResult(car.getName(), car.getDistance()));
        }

        return results;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}

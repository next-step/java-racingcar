package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final List<Car> cars;
    private final Round round;

    public Racing(List<Car> cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public void race() {
        round.play(cars);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public RacingResult getResult() {
        return round.getRacingResult();
    }
}

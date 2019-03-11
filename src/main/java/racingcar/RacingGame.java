package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int times;

    public RacingGame(int times) {
        this.times = times;
    }

    public List<Integer> race(List<Car> cars, NumberGenerator numberGenerator) {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            car.move(numberGenerator);
            positions.add(car.getPosition());
        }
        return positions;
    }

    public int getTimes() {
        return this.times;
    }
}

package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> cars;

    public Racing(Integer carCount) {
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> playRound() {
        cars.forEach(Car::play);
        return this.cars;
    }
}

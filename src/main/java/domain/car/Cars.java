package domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void play(int attemptNumber) {
        cars.forEach(car -> car.play(attemptNumber));
    }

    private void fixMaxDistance(Max max) {
        for (Car car : cars) {
            max.fixMaxValue(car.getDistance());
        }
    }

    public List<Car> findWinner(Max max) {
        fixMaxDistance(max);
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            car.getWinner(winners, max);
        }
        return winners;
    }
}

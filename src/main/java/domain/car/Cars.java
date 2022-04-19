package domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void play(int attemptNumber) {
        for (Car car : cars) {
            car.play(attemptNumber);
        }
    }

    public void fixMaxDistance(Max max) {
        for (Car car : cars) {
            max.fixMaxValue(car.getDistance());
        }

    }

    public List<Car> findWinner(Max max) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            getWinner(winners, max ,car);
        }
        return winners;
    }

    private List<Car> getWinner(List<Car> list, Max max, Car car) {
        if (max.equals(new Max(car.getDistance()))) {
            list.add(car);
        }
        return list;
    }
}

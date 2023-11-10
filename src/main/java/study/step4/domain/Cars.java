package study.step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars winners() {
        List<Car> winners = new ArrayList<>();
        for (Car car: cars) {
            addWinner(winners, car);
        }
        return new Cars(winners);
    }

    private void addWinner(List<Car> winners, Car car) {
        if (car.position().getPosition() == maxPosition()) {
            winners.add(car);
        }
    }

    public int maxPosition() {
        int maxPosition = 0;
        for (Car car: cars) {
            maxPosition = car.greaterThanPosition(maxPosition);
        }
        return maxPosition;
    }
}

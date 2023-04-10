package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameResult {
    List<Car> cars;
    GameResult(CarNumber carNumber) {
        cars = new ArrayList<>();
        for (int i = 0; i < carNumber.getCarNumber(); i++) {
            cars.add(new Car());
        }
    }

    GameResult(GameResult gameResult) {
        cars = new ArrayList<>();
        for (Car car : gameResult.cars) {
            cars.add(new Car(car));
        }
    }

    GameResult(List<Car> cars) {
        this.cars = cars;
    }

    public Car getCar(int j) {
        return cars.get(j);
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GameResult))
            return false;
        return Objects.equals(this.cars, ((GameResult) obj).cars);
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}

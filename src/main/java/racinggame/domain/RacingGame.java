package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public int carsCount() {
        return this.cars.size();
    }

    public void play() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> cars() {
        return this.cars;
    }

    public List<MovingDistance> report() {
        List<MovingDistance> movingDistances = new ArrayList<>();
        for (Car car : cars) {
            movingDistances.add(car.movingDistance());
        }
        return movingDistances;
    }
}

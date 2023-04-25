package CarRacing.domain;

import java.util.ArrayList;
import java.util.List;

public class Competition {
    private static final int DISTANCE_PER_TRY = 1;

    private final MovingStrategy movingStrategy = new MovingStrategyRandom();

    private final List<Car> cars = new ArrayList<>();

    public List<Car> moveCars() {
        for (Car car : cars) {
            car.move(movingStrategy.movable(DISTANCE_PER_TRY));
        }
        return cars;
    }

    public List<Car> winners() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.currentPosition());
        }

        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            addIfWinner(winnerCars, car, max);
        }

        return winnerCars;
    }

    public void addIfWinner(List<Car> winnerCars, Car car, int max) {
        if (max == car.currentPosition()) {
            winnerCars.add(car);
        }
    }

    public void entry(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

}

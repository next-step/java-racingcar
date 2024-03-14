package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static final String DELIMITER = ",";
    private final List<Car> cars;
    private int tryCount;

    public RacingGame(int tryCount) {
        this.cars = new ArrayList<>();
        this.tryCount = tryCount;
    }

    public List<Car> initcars(String inputName) {
        String[] names = inputName.split(DELIMITER);
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void start(MovingStrategy movingStrategy) {
        this.tryCount--;
        moveCars(movingStrategy);
    }

    private void moveCars(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }
}

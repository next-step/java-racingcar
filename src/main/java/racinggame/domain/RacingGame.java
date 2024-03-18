package racinggame.domain;

import java.util.List;

public class RacingGame {
    private Cars cars;
    private int tryCount;

    public RacingGame(List<String> carsName, int tryCount) {
        this.cars = initCars(carsName);
        this.tryCount = tryCount;
    }

    private Cars initCars(List<String> inputNames) {
        return Cars.from(inputNames);
    }

    public void start(MovingStrategy movingStrategy) {
        this.tryCount--;
        moveCars(movingStrategy);
    }

    private void moveCars(MovingStrategy movingStrategy) {
        for (Car car : cars.getCars()) {
            car.move(movingStrategy);
        }
    }

    public List<Name> resultWinnerNames() {
        return cars.getWinnerNames(cars.maxPosition());
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getTryCount() {
        return tryCount;
    }
}

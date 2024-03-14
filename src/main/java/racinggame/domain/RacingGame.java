package racinggame.domain;

import java.util.List;

public class RacingGame {
    private Cars cars;
    private int tryCount;

    public RacingGame(int tryCount) {
        this.cars = new Cars();
        this.tryCount = tryCount;
    }

    public void initCars(String inputName) {
        cars.initCars(inputName);
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

    public List<Name> resultWinnerName() {
        WinnerCar winnerCar = new WinnerCar(cars.getCars());
        return winnerCar.getWinnerName(cars.maxPosition());
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getTryCount() {
        return tryCount;
    }
}

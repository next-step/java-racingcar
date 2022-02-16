package racingcar.domain;

import java.util.List;

public class RacingCarGame {

    private final List<Car> cars;
    private int tryCount;

    public RacingCarGame(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void play() {
        do {
            loadGame();

            tryCount--;
        } while (tryCount > 0);
    }

    public List<Car> getMovingCars() {
        return cars;
    }

    private void loadGame() {
        for (Car car : cars) {
            int randomMove = Movement.getRandomMove();
            car.move(randomMove);
        }
    }
}

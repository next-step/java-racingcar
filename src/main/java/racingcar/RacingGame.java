package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final static int MAX_BOUND = 10;
    private final static int MOVABLE_THRESHOLD = 4;

    private final Cars cars;
    private final Random random;

    public RacingGame(Cars cars) {
        this.cars = cars;
        this.random = new Random();
    }

    public void tryGame() {
        for (Car car : cars.getCars()) {
            if (isMovable()) {
                car.forward();
            }
        }
    }

    protected boolean isMovable() {
        return random.nextInt(MAX_BOUND) >= MOVABLE_THRESHOLD;
    }

    public List<String> getWinnerNames() {
        int maxPosition = cars.findMaxPosition();

        List<String> winners = new ArrayList<>();
        for (Car car: cars.getCars()) {
            comparePositionAndAddWinners(winners, car, maxPosition);
        }

        return winners;
    }

    private void comparePositionAndAddWinners(List<String> winners, Car car, int maxPosition) {
        if (car.isPosition(maxPosition)) {
            winners.add(car.getName().getText());
        }
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}

package racingcar.domain;

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
        int carsSize = cars.getCarsSize();
        List<Boolean> movables = getCarMovableList(carsSize);
        cars.moveCars(movables);
    }

    public List<Boolean> getCarMovableList(int size) {
        List<Boolean> movables = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            movables.add(isMovable());
        }

        return movables;
    }

    protected boolean isMovable() {
        return random.nextInt(MAX_BOUND) >= MOVABLE_THRESHOLD;
    }

    public List<String> getWinnerNames() {
        int maxPosition = cars.findMaxPosition();

        return cars.getCarNamesByPosition(maxPosition);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }
}

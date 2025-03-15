package step3;

import step3.random.RandomStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final int moveCount;
    private final RandomStrategy random;
    private final StringBuilder sb = new StringBuilder();

    public RacingGame(int carCount, int moveCount, RandomStrategy random) {
        this.random = random;
        this.moveCount = moveCount;
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public String start() {
        for (int i = 0; i < moveCount; i++) {
            moveCars();
            printCarPositions();
            sb.append("\n");
        }
        return sb.toString();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(random());
        }
    }

    private int random() {
        return random.generateRandomValue();
    }

    private void printCarPositions() {
        for (Car car : cars) {
            sb.append("\n"+car.getPosition());
        }
    }
}

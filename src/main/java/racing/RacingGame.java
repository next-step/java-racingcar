package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private final int MAX_BOUND = 10;

    private int time;
    private int carCount;
    private List<Car> cars = new ArrayList<>();
    private List<Integer> carPositions = new ArrayList<>();
    private Random random = new Random();

    public RacingGame(RacingInputView racingInputView) {
        this.time = racingInputView.time;
        this.carCount = racingInputView.carCount;
        for (int i = 0; i < this.carCount; i++) {
            cars.add(new Car());
        }
    }

    public List<Integer> start() {
        for (int i = 0; i < time; i++) {
            move();
        }
        return carPositions;
    }

    private void move() {
        for (Car car : cars) {
            carPositions.add(car.move(random.nextInt(MAX_BOUND)));
        }
    }
}

package racingcar;

import java.util.List;
import java.util.Random;

public class Racing {
    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;
    private final int maxAttempts;
    private final List<RacingCar> cars;

    public Racing(int maxAttempts, List<RacingCar> cars) {
        this.maxAttempts = maxAttempts;
        this.cars = cars;
    }

    public void start() {
        for (int attempt = 0; attempt < this.maxAttempts; attempt++) {
            turnAroundCircuit();
            Printer.print((attempt+1) +"회차 종료");
        }
    }

    private void turnAroundCircuit() {
        for (RacingCar car : cars) {
            Printer.print(car.move(RANDOM.nextInt(BOUND)));
        }
    }
}

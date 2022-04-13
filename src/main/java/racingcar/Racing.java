package racingcar;

import java.util.List;
import java.util.Random;

public class Racing {
    private final int maxAttempts;
    private final List<RacingCar> cars;
    private static final int BOUND = 10;
    private static final Random random = new Random();

    public Racing(int maxAttempts, List<RacingCar> cars) {
        this.maxAttempts = maxAttempts;
        this.cars = cars;
    }

    public void start() {
        for (int attempt = 0; attempt < this.maxAttempts; attempt++) {
            turnAroundCircuit();
            int round = attempt;
            Printer.print(++round +"회차 종료");
        }
    }

    private void turnAroundCircuit() {
        for (RacingCar car : cars) {
            Printer.print(car.move(random.nextInt(BOUND)));
        }
    }

    public void cleanUp() {
        for (RacingCar car: cars) {
            car.reset();
        }
    }
}

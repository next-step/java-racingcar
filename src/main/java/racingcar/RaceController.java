package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceController {
    private int currentRound;
    private final int tryCount;
    private final List<Car> cars;

    private static final Random random = new Random();

    private static final int RANDOM_BOUND = 10;

    public RaceController(List<Car> cars, int tryCount) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
        currentRound = 1;
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public void doRaceRound() {
        currentRound++;
        cars.forEach(car -> {
            int randomValue = random.nextInt(RANDOM_BOUND);
            car.race(randomValue);
        });
        RaceView.printCars(cars);
    }

    public void startRacing() {
        System.out.println("실행 결과");
        while (currentRound <= this.tryCount) {
            doRaceRound();
        }
    }
}

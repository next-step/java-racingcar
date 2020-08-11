package racingcar;

import java.util.Random;

public class RacingCar {

    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;
    private static final int BENCHMARK = 4;

    private final String name;
    private int laps = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int record() {
        return laps;
    }

    public void race() {
        if (RANDOM.nextInt(BOUND) >= BENCHMARK) {
            laps++;
        }
    }
}

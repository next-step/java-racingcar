package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    public static final int MAX_BOUND = 10;

    private final Cars cars;
    private final Random random;

    public Racing(Cars cars, Random random) {
        this.cars = cars;
        this.random = random;
    }

    public List<RacingResult> play() {
        List<RacingResult> racingResults = new ArrayList<>();

        for (Car car : cars.getCars()) {
            car.move(getRandomNum());
            RacingResult racingResult = new RacingResult(car.getName(), car.getCurrentPosition());
            racingResults.add(racingResult);
        }
        return racingResults;
    }

    private int getRandomNum() {
        return random.nextInt(MAX_BOUND);
    }
}

package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    public static final int MAX_BOUND = 10;

    private final List<Car> cars;

    public Racing(List<Car> cars) {
        this.cars = cars;
    }

    public List<RacingResult> play() {
        List<RacingResult> racingResults = new ArrayList<>();

        for (Car car : cars) {
            car.move(getRandomNum());
            RacingResult racingResult = new RacingResult(car.getName(), car.getCurrentPosition());
            racingResults.add(racingResult);
        }
        return racingResults;
    }

    protected int getRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }
}

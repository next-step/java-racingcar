package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    private static final Random RANDOM = new Random();

    private final List<Car> cars;

    public Racing(List<Car> cars) {
        this.cars = cars;
    }

    public List<RacingResult> play() {
        List<RacingResult> racingResults = new ArrayList<>();

        for (Car car : cars) {
            car.move(RANDOM.nextInt(10));
            RacingResult racingResult = new RacingResult(car.getName(), car.getCurrentPosition());
            racingResults.add(racingResult);
        }
        return racingResults;
    }

}

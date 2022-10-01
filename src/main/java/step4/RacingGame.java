package step4;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    static List<RacingResult> start(List<Car> cars) {
        List<RacingResult> racingResults = new ArrayList<>();

        for (Car car : cars) {
            car.moveForward(randomNumber());
            racingResults.add(new RacingResult(car));
        }

        return racingResults;
    }

    private static int randomNumber() {
        return new RandomNumber().getRandomNumber();
    }
}

package racingcar.domain;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingManager {

    private final Cars cars;
    private final int round;

    public RacingManager(final String carNames, final int round) {
        this.cars = new Cars(parse(carNames));
        this.round = round;
    }

    private List<Car> parse(final String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(toList());
    }

    public RacingResult playRacing() {
        RacingResult racingResult = new RacingResult();
        racingResult.addResult(cars.copy());
        for (int i = 0; i < round; i++) {
            cars.takeTurn();
            racingResult.addResult(cars.copy());
        }
        racingResult.addWinnerNames(cars.findWinnerNames());
        return racingResult;
    }
}

package racingcar.domain;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingManager {

    private final Cars cars;
    private final int round;
    private final RacingResult racingResult;

    public RacingManager(String carNames, int round) {
        this.cars = new Cars(parse(carNames));
        this.round = round;
        racingResult = new RacingResult();
    }

    private List<Car> parse(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(toList());
    }

    public RacingResult playRacing() {
        for (int i = 0; i < round; i++) {
            cars.takeTurn();
            racingResult.addResult(cars);
        }
        racingResult.computeWinner(cars);
        return racingResult;
    }
}

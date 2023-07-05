package racingcar;

import java.util.List;

public class RacingManager {

    private final Cars cars;
    private final int round;
    private final RacingResult racingResult;

    public RacingManager(List<String> carNames, int round) {
        this.cars = Cars.from(carNames);
        this.round = round;
        racingResult = new RacingResult();
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

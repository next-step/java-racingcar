package racingcar.domain;

import racingcar.dto.CarResultDto;

import java.util.List;

public class RacingGame {
    private static final int MOVABLE_THRESHOLD = 4;

    private final RoundResults roundResults = new RoundResults();

    public void startGame(List<String> carNames, int trial) {
        Cars cars = Cars.namesOf(carNames);
        for (int i = 0; i < trial; i++) {
            cars.race(MOVABLE_THRESHOLD);
            roundResults.recordResults(cars.getCars());
        }
    }

    public List<List<CarResultDto>> getRoundResults() {
        return roundResults.getResults();
    }
}

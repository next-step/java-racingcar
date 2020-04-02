package racinggame.domain.racing;

import racinggame.domain.car.Cars;
import racinggame.util.NumberUtil;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private static final String INPUT_ERROR_MESSAGE = "1이상의 값을 입력해야 합니다.";
    private static final int RACING_MINIMUM_ROUND_COUNT = 1;

    private Cars cars;
    private int gameCount;
    private RacingRoundResults racingRoundResults;

    public Racing(List<String> carNames, int gameCount) {
        validateGameCount(gameCount);
        this.gameCount = gameCount;
        this.cars = Cars.newRacingCarsFrom(carNames);
        this.racingRoundResults = new RacingRoundResults();
    }

    private void validateGameCount(int gameCount) {
        if (!NumberUtil.isGreaterThan(gameCount, RACING_MINIMUM_ROUND_COUNT)) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    private void playOneRound() {
        this.cars = this.cars.moveCarAll();
        saveRoundResult();
    }

    private void saveRoundResult() {
        this.racingRoundResults = this.racingRoundResults.addResult(this.cars);
    }

    public void playAllRound() {
        for (int i = 0; i < this.gameCount; i++) {
            playOneRound();
        }
    }

    public List<String> findWinner() {
        return new ArrayList<>(cars.findWinner());
    }

    public RacingRoundResults getRacingRoundResults() {
        return new RacingRoundResults(this.racingRoundResults);
    }
}

package racingcar.model;

import java.util.List;

public class RacingGameRequest {
    private final List<String> carNames;
    private final int countOfTry;

    public RacingGameRequest(List<String> carNames, int countOfTry) {
        this.carNames = carNames;
        this.countOfTry = countOfTry;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getCountOfTry() {
        return countOfTry;
    }
}

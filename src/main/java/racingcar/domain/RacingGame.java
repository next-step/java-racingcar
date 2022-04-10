package racingcar.domain;

import java.util.List;

public class RacingGame {

    private InputCarCount carCount;
    private InputRoundCount roundCount;
    private List<Car> cars;

    public RacingGame(InputCarCount carCount, InputRoundCount roundCount) {
        if (carCount == null || roundCount == null) {
            throw new IllegalArgumentException();
        }

        this.carCount = carCount;
        this.roundCount = roundCount;
    }
}

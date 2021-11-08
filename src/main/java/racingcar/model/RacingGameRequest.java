package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class RacingGameRequest {
    private static final String CAR_NAME_DELIMITER = ",";
    private final List<String> carNames;
    private final int countOfTry;

    public RacingGameRequest(String carNames, int countOfTry) {
        this.carNames = Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
        this.countOfTry = countOfTry;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getCountOfTry() {
        return countOfTry;
    }
}

package racinggame.domain;

import racinggame.util.NumberUtil;

import java.util.Arrays;
import java.util.List;

public class UserInput {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String INPUT_ERROR_MESSAGE = "1이상의 값을 입력해야 합니다.";
    private static final int RACING_MINIMUM_ROUND_COUNT = 1;

    private List<String> carNames;
    private int gameCount;

    public UserInput(String carNames, int gameCount) {
        validateGameCount(gameCount);
        this.gameCount = gameCount;
        this.carNames = careateCarNames(carNames);
    }

    private void validateGameCount(int gameCount) {
        if (!NumberUtil.isGreaterThan(gameCount, RACING_MINIMUM_ROUND_COUNT)) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    private List<String> careateCarNames(String carNames) {
        return Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getGameCount() {
        return gameCount;
    }
}

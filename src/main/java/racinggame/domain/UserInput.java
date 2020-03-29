package racinggame.domain;

import java.util.Arrays;
import java.util.List;

public class UserInput {

    private static final String CAR_NAME_DELIMITER = ",";

    private List<String> carNames;
    private int gameCount;

    public UserInput(String carNames, int gameCount) {
        this.gameCount = gameCount;
        this.carNames = careateCarNames(carNames);
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

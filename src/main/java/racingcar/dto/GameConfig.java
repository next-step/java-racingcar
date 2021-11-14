package racingcar.dto;

import static racingcar.utils.IntegerUtils.*;

import java.util.List;


public class GameConfig {

    private final List<String> joinCarNames;
    private final int maxOfRound;

    public GameConfig(List<String> joinCarNames, int maxOfRound) {
        this.joinCarNames = joinCarNames;
        this.maxOfRound = isPositiveNumber(maxOfRound);
    }

    public int getNumberOfCars() {
        return joinCarNames.size();
    }

    public int getMaxOfRound() {
        return maxOfRound;
    }

}

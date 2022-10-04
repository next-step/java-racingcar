package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RacingGameCondition {

    private final List<String> racingCarNames;
    private final int gameTurnCount;

    public RacingGameCondition(String racingCarNamesJointComma, int gameTurnCount) {
        this.racingCarNames = List.of(racingCarNamesJointComma.split(","));
        this.gameTurnCount = gameTurnCount;
    }

    public List<String> getRacingCarNames() {
        return Collections.unmodifiableList(racingCarNames);
    }

    public int getGameTurnCount() {
        return gameTurnCount;
    }
}

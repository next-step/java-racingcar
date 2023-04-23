package racingcar.dto;

import racingcar.domain.GameRound;
import racingcar.domain.InputNames;

import java.util.List;

public class UserInput {
    private final GameRound gameRound;
    private InputNames inputNames;

    public UserInput(int gameRound, String names) {
        this.gameRound = new GameRound(gameRound);
        this.inputNames = new InputNames(names);
    }

    public GameRound getGameRound() {
        return gameRound;
    }

    public List<String> getCarNames() {
        return inputNames.getCarNames();
    }

}

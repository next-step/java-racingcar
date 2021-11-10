package racinggame.utils;

import racinggame.GameExecutor;
import racinggame.SimpleGameExecutor;
import racinggame.exception.NotInstanceException;

public class GameExecutorFactory {

    private GameExecutorFactory() {
        throw new NotInstanceException();
    }

    public static GameExecutor createGameExecutor(String carNames, String numberOfAttempts) {
        return new SimpleGameExecutor(InputUtils.convertInputValue(carNames, numberOfAttempts));
    }
}

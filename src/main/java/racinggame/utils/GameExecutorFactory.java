package racinggame.utils;

import racinggame.SimpleGameExecutor;
import racinggame.exception.NotInstanceException;

public class GameExecutorFactory {

    private GameExecutorFactory() {
        throw new NotInstanceException();
    }

    public static SimpleGameExecutor createGameExecutor(String carNames, String numberOfAttempts) {
        return new SimpleGameExecutor(InputUtils.convertInputValue(carNames, numberOfAttempts));
    }
}

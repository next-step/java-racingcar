package racinggame.utils;

import racinggame.GameExecutor;
import racinggame.SimpleGameExecutor;
import racinggame.exception.NotInstanceException;

public class GameExecutorFactory {

    private GameExecutorFactory() {
        throw new NotInstanceException();
    }

    public static GameExecutor createGameExecutor(String numberOfCars, String numberOfAttempts) {
        return new SimpleGameExecutor(InputUtils.convertInputValue(numberOfCars, numberOfAttempts));
    }
}

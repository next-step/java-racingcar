package racinggame.utils;

import racinggame.GameExecutor;
import racinggame.SimpleGameExecutor;

public class GameExecutorFactory {

    private GameExecutorFactory() {
    }

    public static GameExecutor createGameExecutor(String numberOfCars, String numberOfAttempts) {
        return new SimpleGameExecutor(InputUtils.convertInputValue(numberOfCars, numberOfAttempts));
    }
}

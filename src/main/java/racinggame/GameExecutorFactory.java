package racinggame;

public class GameExecutorFactory {

    public static GameExecutor createGameExecutor(String numberOfCars, String numberOfAttempts) {
        return new SimpleGameExecutor(InputUtils.convertInputValue(numberOfCars, numberOfAttempts));
    }
}

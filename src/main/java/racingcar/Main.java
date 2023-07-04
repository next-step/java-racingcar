package racingcar;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (InputManager inputManager = new InputManager()) {
            OutputManager outputManager = new OutputManager();
            play(inputManager, outputManager);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void play(InputManager inputManager, OutputManager outputManager) throws IOException {
        Cars cars = Cars.from(inputManager.readCarNames());
        int round = inputManager.readRound();
        RacingManager racingManager = new RacingManager(cars);
        outputManager.printExecutionResult();
        outputManager.printCars(cars);
        for (int i = 0; i < round; i++) {
            cars = racingManager.playRacing();
            outputManager.printCars(cars);
        }
        outputManager.printWinnerNames(cars.findWinnerNames());
    }
}

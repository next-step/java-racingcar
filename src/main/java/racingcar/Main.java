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
        RacingManager racingManager = new RacingManager(inputManager.readCarNames(), inputManager.readRound());
        RacingResult racingResult = racingManager.playRacing();
        outputManager.printResult(racingResult);
    }
}

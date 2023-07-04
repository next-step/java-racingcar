package racingcar;

import java.io.IOException;

public class GameManager {

    public static void playGame() {
        try (InputManager inputManager = new InputManager()) {
            RacingManager racingManager = RacingManager.of(inputManager.readCarNames(), inputManager.readRound());
            RacingViewManager racingViewManager = new RacingViewManager(racingManager);
            racingManager.playRacing();
            racingViewManager.printResult();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

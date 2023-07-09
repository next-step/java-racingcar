package racingcar.controller;

import racingcar.view.RacingViewManager;
import racingcar.domain.RacingManager;

import java.io.IOException;

public class GameManager {

    public static void playGame() {
        RacingManager racingManager = getRacingManagerByInput();
        RacingViewManager racingViewManager = new RacingViewManager(racingManager);
        racingManager.playRacing();
        racingViewManager.printResult();
    }

    private static RacingManager getRacingManagerByInput() {
        try (InputManager inputManager = new InputManager()) {
            return RacingManager.of(inputManager.readCarNames(), inputManager.readRound());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

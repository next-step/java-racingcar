package racingcar.controller;

import racingcar.view.RacingView;
import racingcar.domain.RacingManager;

import java.io.IOException;

public class GameController {

    public static void playGame() {
        RacingManager racingManager = getRacingManagerByInput();
        RacingView racingViewManager = new RacingView(racingManager);
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

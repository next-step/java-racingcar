package racingcar.controller;

import racingcar.domain.RacingManager;
import racingcar.domain.RacingResult;
import racingcar.view.InputManager;
import racingcar.view.OutputManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (final InputManager inputManager = new InputManager()) {
            final OutputManager outputManager = new OutputManager();
            play(inputManager, outputManager);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void play(final InputManager inputManager, final OutputManager outputManager) throws IOException {
        final RacingManager racingManager = new RacingManager(inputManager.readCarNames(), inputManager.readRound());
        RacingResult racingResult = racingManager.playRacing();
        outputManager.printResult(racingResult);
    }
}

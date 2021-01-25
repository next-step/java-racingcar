package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

import static racingcar.view.InputMessages.ENTER_CAR_NAMES;
import static racingcar.view.InputMessages.ENTER_ROUNDS;

public class GameController {
    private final Input input;
    private final Output output;

    public GameController(final Input input, final Output output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        output.printOutput(ENTER_CAR_NAMES);
        List<String> carNames = input.getCarNames();
        output.printOutput(ENTER_ROUNDS);
        int rounds = input.getRounds();
        RacingGame game = new RacingGame(carNames, rounds);
        game.play();
    }
}

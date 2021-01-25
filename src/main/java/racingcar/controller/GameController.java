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
        List<String> carNames = getCarNames();
        int rounds = getRounds();
        RacingGame game = new RacingGame(carNames, rounds);

        output.startPrintingGameResult();
        while (!game.ends()) {
            game.playOneRound();
            output.printMidResult(game.getCars());
        }
        output.printWinners(game.getWinners());
    }

    private List<String> getCarNames() {
        output.println(ENTER_CAR_NAMES);
        return input.getCarNames();
    }

    private int getRounds() {
        output.println(ENTER_ROUNDS);
        return input.getRounds();
    }
}

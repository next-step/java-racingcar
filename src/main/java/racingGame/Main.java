package racingGame;

import racingGame.controller.RacingGame;
import racingGame.model.strategy.RandomMovementStrategy;
import racingGame.service.RacingGameService;
import racingGame.ui.input.InputView;
import racingGame.ui.input.ConsoleInputView;
import racingGame.ui.output.OutputView;
import racingGame.ui.output.ConsoleOutputView;

public class Main {
    public static void main(String[] args) {
        RacingGameService gameService = new RacingGameService(new RandomMovementStrategy());
        InputView input = new ConsoleInputView();
        OutputView output = new ConsoleOutputView();

        RacingGame game = new RacingGame(input, output, gameService);

        game.play();
    }
}

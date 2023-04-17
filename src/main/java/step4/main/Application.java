package step4.main;

import step4.service.RacingCarGame;
import step4.domain.entity.UserInput;
import step4.view.InputView;

import static step4.view.OutputView.printCars;
import static step4.view.OutputView.printResultConsole;
import static step4.view.OutputView.printWinners;

public class Application {

    public static void main(String[] args) {
        final UserInput input = InputView.input();
        final RacingCarGame game = new RacingCarGame(input.getName());

        printResultConsole();

        for (int i = 0; i < input.getRetry(); i++) {
            game.playing();

            printCars(game);
        }

        printWinners(game.winnerNames());
    }
}

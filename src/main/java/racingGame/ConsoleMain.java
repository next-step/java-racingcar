package racingGame;

import racingGame.domain.GameResult;
import racingGame.domain.RacingGame;
import racingGame.view.InputType;
import racingGame.view.InputView;
import racingGame.view.ResultView;

public class ConsoleMain {

    public static void main(String[] args) {
        String carNames = InputView.inputCarNames(InputType.CAR);
        int move = InputView.inputMove(InputType.MOVE);

        RacingGame game = new RacingGame(carNames, move);

        while (game.hasNextRound()) {
            game.move();
            ResultView.printRound(game.getCarsInGame());
        }

        ResultView.printWinners(GameResult.getWinners(game.getCarsInGame()));
    }
}

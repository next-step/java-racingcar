package racingcar;

import racingcar.domain.Cars;
import racingcar.utils.InputView;
import racingcar.utils.OutputView;

public class Application {

    public static void main(String[] args) {
        Game game = new Game(new Cars(InputView.getCarNames()));
        int turn = InputView.getTurn();

        OutputView.printTurnResult();
        for (int index = 0; index < turn; index++) {
            game.play();
        }

        OutputView.printWhoIsWinner(game.winners());
    }
}

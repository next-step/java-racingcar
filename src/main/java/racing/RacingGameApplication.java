package racing;

import racing.domain.Game;
import racing.ui.InputView;
import racing.ui.Message;
import racing.ui.ResultView;

public class RacingGameApplication {

  public static void main(String[] args) {
    String cars = InputView.inputCar(Message.INPUT_CAR_NAME);
    int tryCnt = InputView.inputTryCnt(Message.INPUT_TRY_COUNT);

    Game game = new Game(cars, tryCnt);
    while (game.canRace()) {
      game.playRound();
      ResultView.printRoundResult(game.getRacingResult());
    }
    ResultView.printWinners(game.getWinners());
  }
}

package racing;

import racing.domain.Game;
import racing.domain.MovementStrategy;
import racing.ui.InputView;
import racing.ui.Message;
import racing.ui.ResultView;

public class GameApplication {

  public static void main(String[] args) {
    InputView input = new InputView();
    int carCnt = input.input(Message.INPUT_CAR_COUNT);
    int tryCnt = input.input(Message.INPUT_TRY_COUNT);
    MovementStrategy strategy = new MovementStrategy(0, 9);

    Game game = new Game(strategy, carCnt, tryCnt);
    ResultView result = new ResultView();
    result.printStart();

    for (int i = 0; i < tryCnt; i++) {
      game.play();
      result.printRoundResult(game.getCars());
    }

    input.close();
  }
}

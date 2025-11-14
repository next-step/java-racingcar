package racing;

import java.util.List;
import racing.domain.Car;
import racing.domain.CarName;
import racing.domain.Game;
import racing.domain.MovementStrategy;
import racing.domain.Participants;
import racing.ui.InputView;
import racing.ui.Message;
import racing.ui.ResultView;

public class GameApplication {

  public static void main(String[] args) {
    List<CarName> carNames = InputView.inputCarName(Message.INPUT_CAR_NAME);
    int tryCnt = InputView.inputTryCnt(Message.INPUT_TRY_COUNT);
    InputView.close();

    MovementStrategy strategy = new MovementStrategy(0, 9);
    Participants participants = new Participants(carNames);

    Game game = new Game(strategy, participants, tryCnt);
    ResultView.printResultMessage();
    for (int i = 0; i < tryCnt; i++) {
      game.play();
      ResultView.printRoundResult(game.getParticipants());
    }
    List<Car> winners = game.getWinners();
    ResultView.printWinner(winners);
  }
}

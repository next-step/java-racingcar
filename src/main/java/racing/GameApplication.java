package racing;

import java.util.List;
import racing.domain.CarName;
import racing.domain.Game;
import racing.domain.MovementStrategy;
import racing.domain.Participants;
import racing.domain.RacingGame;
import racing.ui.InputView;
import racing.ui.Message;

public class GameApplication {

  public static void main(String[] args) {
    List<CarName> carNames = InputView.inputCarName(Message.INPUT_CAR_NAME);
    int tryCnt = InputView.inputTryCnt(Message.INPUT_TRY_COUNT);

    MovementStrategy strategy = new MovementStrategy(0, 9);
    Participants participants = new Participants(carNames);
    RacingGame racingGame = new RacingGame(new Game(strategy, participants), tryCnt);
    racingGame.play();
  }
}

package racing;

import java.util.List;
import racing.domain.Game;
import racing.domain.MovementStrategy;
import racing.domain.Participants;
import racing.domain.RacingGame;
import racing.domain.RoundCount;
import racing.ui.InputView;
import racing.ui.Message;

public class GameApplication {

  public static void main(String[] args) {
    List<String> cars = InputView.inputCar(Message.INPUT_CAR_NAME);
    int tryCnt = InputView.inputTryCnt(Message.INPUT_TRY_COUNT);

    MovementStrategy strategy = new MovementStrategy();
    Participants participants = Participants.from(cars);
    RacingGame racingGame = new RacingGame(new Game(strategy, participants),
        new RoundCount(tryCnt));
    racingGame.play();
  }
}

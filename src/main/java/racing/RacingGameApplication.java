package racing;

import java.util.List;
import racing.domain.Game;
import racing.domain.MovementStrategy;
import racing.domain.Participants;
import racing.domain.RoundCount;
import racing.ui.InputView;
import racing.ui.Message;
import racing.ui.ResultView;

public class RacingGameApplication {

  public static void main(String[] args) {
    List<String> cars = InputView.inputCar(Message.INPUT_CAR_NAME);
    int tryCnt = InputView.inputTryCnt(Message.INPUT_TRY_COUNT);

    MovementStrategy strategy = new MovementStrategy();
    Participants participants = Participants.from(cars);
    Game game = new Game(strategy, participants);
    RoundCount round = new RoundCount(tryCnt);

    ResultView.printResultMessage();
    while (round.canRace()) {
      game.playRound();
      ResultView.printRoundResult(game.getParticipants());
      round.doRace();
    }
    ResultView.printWinner(game.getWinners());
  }
}

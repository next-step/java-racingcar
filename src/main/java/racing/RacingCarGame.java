package racing;

import racing.core.RacingCar;
import racing.core.RacingRound;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class RacingCarGame {

  private List<RacingCar> players;

  private int totalRound;

  public static void main(String[] args) {
    InputView inputView = InputView.executeConsole();
    List<RacingRound> result = RacingCarGame.ready(inputView)
            .play();

    ResultView.print(result);
  }

  public static RacingCarGame ready(InputView inputView) {
    RacingCarGame racingCarGame = new RacingCarGame();
    racingCarGame.players = IntStream.range(0, inputView.getTotalPlayer())
            .mapToObj(RacingCar::createNew)
            .collect(Collectors.toList());

    racingCarGame.totalRound = inputView.getTotalRound();
    return racingCarGame;
  }

  public List<RacingRound> play() {
    List<RacingRound> result = new ArrayList<>(totalRound);
    for (int i = 0; i < totalRound; i++) {
      RacingRound round = new RacingRound();
      round.record(players);
      result.add(round);
    }
    return result;
  }

}

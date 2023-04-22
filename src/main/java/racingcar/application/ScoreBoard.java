package racingcar.application;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarNames;

public class ScoreBoard {

  private final List<GameHistoryRecord> history = new ArrayList<>();

  public void record(Cars cars) {
    history.add(new GameHistoryRecord(cars));
  }

  public CarNames latestWinner() {
    return history
        .get(history.size() - 1)
        .cars()
        .winnerName();
  }
}

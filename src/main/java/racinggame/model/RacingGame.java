package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
  private static final int RACING_START_VALUE = 1;

  private Cars cars;
  private int time;
  private List<RacingInfo> racingInfos;

  public RacingGame(String names, int time) {
    cars = new Cars(names);
    this.time = time;
    racingInfos = new ArrayList<>();
  }

  public List<RacingInfo> startGame() {
    for (int i = RACING_START_VALUE; i <= time; i++) {
      move().getCars()
            .stream()
            .forEach(c -> racingInfos.add(new RacingInfo(c.getName(), c.getStatus())));
    }
    return racingInfos;
  }

  public String getWinner() {
    return cars.getWinner();
  }

  private Cars move() {
    return cars.moveCars();
  }
}

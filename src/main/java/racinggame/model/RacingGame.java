package racinggame.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
  private static final int RACING_START_VALUE = 1;

  private Cars cars;
  private int time;

  public RacingGame(String names, int time) {
    cars = new Cars(names);
    this.time = time;
  }

  public List<RacingInfo> startGame() {
    List<RacingInfo> racingInfos = new ArrayList<>();

    for (int i = RACING_START_VALUE; i <= time; i++) {
      move().getCars()
            .forEach(car -> racingInfos.add(new RacingInfo(car.getName(), car.getStatus())));
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

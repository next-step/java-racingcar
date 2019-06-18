package racingcar;

import java.util.List;

public class Position {

  private List<Integer> carPosition;

  public Position(List<Integer> positions) {
    carPosition = positions;
  }

  public List getCarPosition() {
    return carPosition;
  }

}
